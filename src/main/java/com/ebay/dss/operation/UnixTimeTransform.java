package com.ebay.dss.operation;

import cascading.flow.FlowProcess;
import cascading.operation.BaseOperation;
import cascading.operation.Function;
import cascading.operation.FunctionCall;
import cascading.tuple.Fields;
import cascading.tuple.Tuple;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * transform the UNIXTIME to standard datetime. Anc change the Timezone from GMT to PST
 * Author: Johnson CHEN
 * Date: 2014/09/26
 */


public class UnixTimeTransform extends BaseOperation
        implements Function {

    public UnixTimeTransform() {
        super(1,Fields.ARGS);
    }

    @Override
    public void operate(FlowProcess flowProcess, FunctionCall functionCall) {
        Tuple t = functionCall.getArguments().getTupleCopy();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-7"));

        functionCall.getOutputCollector().add(new Tuple(sdf.format(new Date(Long.parseLong(t.getString(0)) * 1000))));
    }
}
