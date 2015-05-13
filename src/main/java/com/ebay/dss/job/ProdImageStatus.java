package com.ebay.dss.job;

import cascading.flow.Flow;
import cascading.flow.FlowDef;
import cascading.pipe.Each;
import cascading.pipe.Pipe;
import cascading.pipe.assembly.Retain;
import cascading.pipe.assembly.Unique;
import cascading.scheme.hadoop.TextDelimited;
import cascading.tap.SinkMode;
import cascading.tap.Tap;
import cascading.tap.hadoop.Hfs;
import cascading.tuple.Fields;
import com.ebay.dss.common.FieldNames;
import com.ebay.dss.operation.ProdImageStatusFunc;
import com.ebay.hadoop.cascading.PlumbumApp;
import com.ebay.hadoop.cascading.scheme.FormattedSequenceFile;
import com.ebay.hadoop.cascading.util.StringUtil;
import com.ebay.hadoop.platform.hdal.edw.CtProductSearchIndex;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

/**
 * Description: parse PROD IMAGE STATUS
 * Author: Johnson CHEN
 * Date: 2014/12/1.
 */
public class ProdImageStatus extends PlumbumApp {
    /**
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        int ret = ToolRunner.run(new Configuration(), new ProdImageStatus(), args);
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
        ), false, "\177"), getOptionValue(INPUT));*/
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
        //parsePipe = new Each(parsePipe, StringUtil.fields(CtProductSearchIndex.LAST_MODIFIED_DATE),new UnixTimeTransform(),Fields.REPLACE);
        parsePipe = new Each(parsePipe, StringUtil.fields(CtProductSearchIndex.INDEX_MESSAGE), new ProdImageStatusFunc(FieldNames.PROD_IMAGE_STATUS), Fields.SWAP);
        parsePipe = new Retain(parsePipe, StringUtil.fields(CtProductSearchIndex.PROD_REFERENCE_ID, CtProductSearchIndex.PRODUCT_ID, FieldNames.IMAGE_STATUS, FieldNames.SEQ_NUM));
        parsePipe = new Unique(parsePipe, Fields.ALL);
        return parsePipe;
    }
}
