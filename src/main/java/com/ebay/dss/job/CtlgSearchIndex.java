package com.ebay.dss.job;

import cascading.flow.Flow;
import cascading.flow.FlowDef;
import cascading.pipe.Each;
import cascading.pipe.Pipe;
import cascading.pipe.assembly.Coerce;
import cascading.pipe.assembly.Retain;
import cascading.pipe.assembly.Unique;
import cascading.scheme.hadoop.TextDelimited;
import cascading.tap.SinkMode;
import cascading.tap.Tap;
import cascading.tap.hadoop.Hfs;
import cascading.tuple.Fields;
import com.ebay.dss.common.FieldNames;
import com.ebay.dss.operation.IndexMessageFunc;
import com.ebay.dss.operation.UnixTimeTransform;
import com.ebay.hadoop.cascading.PlumbumApp;
import com.ebay.hadoop.cascading.scheme.FormattedSequenceFile;
import com.ebay.hadoop.cascading.util.StringUtil;
import com.ebay.hadoop.platform.hdal.edw.CtProductSearchIndex;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

/**
 * Description: parse CT_PROD_SEARCH_INDEX
 * Author: Johnson CHEN
 * Date: 2014/9/25.
 */
public class CtlgSearchIndex extends PlumbumApp {
    /**
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        int ret = ToolRunner.run(new Configuration(), new CtlgSearchIndex(), args);
        System.exit(ret);
    }

    @Override
    protected void createOptions() {
        addOption(INPUT);
        addOption(OUTPUT);
    }

    @Override
    protected void buildCascade() throws Exception {
        Tap ctProdSearchIndexTap = new Hfs(new FormattedSequenceFile("CT_PRODUCT_SEARCH_INDEX"), getOptionValue(INPUT));
/*        Tap ctProdSearchIndexTap = new Hfs(new TextDelimited(StringUtil.fields(
                CtProductSearchIndex.PROD_REFERENCE_ID,
                CtProductSearchIndex.PRODUCT_ID,
                CtProductSearchIndex.INDEX_MESSAGE,
                CtProductSearchIndex.TRANSIENT_INDEX_MESSAGE,
                CtProductSearchIndex.TRANSIENT_INDEX_MESSAGE2,
                CtProductSearchIndex.LAST_MODIFIED_DATE
                ),false,"\177"), getOptionValue(INPUT));*/
        Tap ctlgSearchIndexParsedTap = new Hfs(new TextDelimited(false, "\177"), getOptionValue(OUTPUT), SinkMode.REPLACE);

        Pipe parsePipe = buildPipe();

        FlowDef flowDef = FlowDef.flowDef()
                .setName(getClass().getSimpleName())
                .addSource(parsePipe, ctProdSearchIndexTap)
                .addTailSink(parsePipe, ctlgSearchIndexParsedTap);

        Flow flow = getFlowConnector().connect(flowDef);
        addFlow(flow);
    }

    public Pipe buildPipe() {
        Pipe parsePipe = new Pipe("CTLG_PROD_SRCH_INDEX_ATTR_PIPE");
        /*String datetimeTrExp = "new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\",java.).format(new java.util.Date(" + CtProductSearchIndex.LAST_MODIFIED_DATE + " * 1000))";
        ExpressionFunction datetimeTrFunc = new ExpressionFunction(Fields.ARGS, datetimeTrExp, Long.TYPE);
        parsePipe = new Each(parsePipe,StringUtil.fields(CtProductSearchIndex.LAST_MODIFIED_DATE),datetimeTrFunc, Fields.REPLACE);*/
        parsePipe = new Each(parsePipe, StringUtil.fields(CtProductSearchIndex.LAST_MODIFIED_DATE), new UnixTimeTransform(), Fields.REPLACE);
        parsePipe = new Each(parsePipe, StringUtil.fields(CtProductSearchIndex.INDEX_MESSAGE, CtProductSearchIndex.TRANSIENT_INDEX_MESSAGE, CtProductSearchIndex.TRANSIENT_INDEX_MESSAGE2), new IndexMessageFunc(FieldNames.TRANSIENT_INDEX_MESSAGE_PAIR_F), Fields.SWAP);
        parsePipe = new Retain(parsePipe, StringUtil.fields(CtProductSearchIndex.PROD_REFERENCE_ID, CtProductSearchIndex.PRODUCT_ID, CtProductSearchIndex.LAST_MODIFIED_DATE, FieldNames.TRANSIENT_INDEX_MESSAGE_NAME, FieldNames.TRANSIENT_INDEX_MESSAGE_VALUE));
        parsePipe = new Unique(parsePipe, Fields.ALL);
        parsePipe = new Coerce(parsePipe, StringUtil.fields(CtProductSearchIndex.PROD_REFERENCE_ID, CtProductSearchIndex.PRODUCT_ID, FieldNames.TRANSIENT_INDEX_MESSAGE_NAME), Long.TYPE, Long.TYPE, Integer.TYPE);
        return parsePipe;
    }
}
