package com.ebay.dss.job;

import cascading.avro.AvroScheme;
import cascading.flow.Flow;
import cascading.flow.FlowDef;
import cascading.pipe.Each;
import cascading.pipe.Pipe;
import cascading.pipe.assembly.Retain;
import cascading.scheme.hadoop.TextDelimited;
import cascading.tap.SinkMode;
import cascading.tap.Tap;
import cascading.tap.hadoop.Hfs;
import cascading.tuple.Fields;
import com.ebay.dss.operation.ColumnFilter;
import com.ebay.hadoop.cascading.PlumbumApp;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

/**
 * Description: transform the AVRO file into TEXT file. Including some column retain and row filter.
 * Author: Johnson CHEN
 * Date: 2014/11/26.
 */
public class Avro2Text extends PlumbumApp {
    /**
     * @param args
     * @throws Exception
     */

    @SuppressWarnings("static-access")
    protected static final Option COLUMNS = OptionBuilder.withArgName("columns").hasArg().isRequired(false).
            withDescription("retains the input columns(optional)").create("columns");
    @SuppressWarnings("static-access")
    protected static final Option CONDITIONS = OptionBuilder.withArgName("conditions").hasArg().isRequired(false).
            withDescription("column condition clause(optional)").create("conditions");

    public static void main(String[] args) throws Exception {
        int ret = ToolRunner.run(new Configuration(), new Avro2Text(), args);
        System.exit(ret);
    }

    @Override
    protected void createOptions() {
        addOption(COLUMNS);
        addOption(CONDITIONS);
        addOption(INPUT);
        addOption(OUTPUT);
    }

    @Override
    protected void buildCascade() throws Exception {
        Tap avroTap = new Hfs(new AvroScheme(), getOptionValue(INPUT));
        Tap textTap = new Hfs(new TextDelimited(false, "\177"), getOptionValue(OUTPUT), SinkMode.REPLACE);

        Pipe avroToTextPipe = new Pipe("AVRO_TO_TEXT_PIPE");
        if (getOptionValue(COLUMNS) != null && !getOptionValue(COLUMNS).equals("")) {
            String[] columnsArr = getOptionValue(COLUMNS).split(",");
            avroToTextPipe = new Retain(avroToTextPipe, new Fields(columnsArr));
        }

        if (getOptionValue(CONDITIONS) != null && !getOptionValue(CONDITIONS).equals("")) {
            String conditionColumn = getOptionValue(CONDITIONS).split("=", 2)[0].toLowerCase();
            String[] conditionArr = getOptionValue(CONDITIONS).split("=", 2)[1].split(",");
            avroToTextPipe = new Each(avroToTextPipe, new Fields(conditionColumn, String.class), new ColumnFilter(conditionArr));
        }

        FlowDef flowDef = FlowDef.flowDef()
                .setName(getClass().getSimpleName())
                .addSource(avroToTextPipe, avroTap)
                .addTailSink(avroToTextPipe, textTap);

        Flow flow = getFlowConnector().connect(flowDef);
        addFlow(flow);
    }
}
