package com.ebay.dss.operation;

import cascading.flow.FlowProcess;
import cascading.operation.BaseOperation;
import cascading.operation.Function;
import cascading.operation.FunctionCall;
import cascading.tuple.Fields;
import cascading.tuple.Tuple;
import cascading.tuple.TupleEntry;
import com.ebay.dss.common.FieldNames;

/**
 * parse the index_message data. Get 4 Attribute_id and do normalization
 * One record to multiple records
 * Author: Johnson CHEN
 * Date: 2014/09/26
 */


public class IndexMessageFunc extends BaseOperation
        implements Function {

    public IndexMessageFunc(Fields newFields) {
        super(ANY, newFields);
    }

    @Override
    public void operate(FlowProcess flowProcess, FunctionCall functionCall) {
        TupleEntry argument = functionCall.getArguments();

        Tuple result = new Tuple();
        TupleEntry resultTupleEntry;
        String[] input;

        /* INDEX_MESSAGE & TRANSIENT_INDEX_MESSAGE & TRANSIENT_INDEX_MESSAGE2 */
        for (int i = 0; i < argument.size(); i++) {
            if (argument.getString(i) != null && !argument.getString(i).equals("")) {
                input = argument.getString(i).split("\\|");
                for (String ss : input) {
                    String[] sss = ss.trim().split("\\s", 3);
                    if (sss.length >= 3)
                    {
                        String name = sss[0];
                        String[] attrValues = sss[2].split("\\s");
                        if (name.equals("11") || name.equals("26") || name.equals("215") || name.equals("346")) {
                            for (String value : attrValues) {
                                result.clear();
                                result.add(name);
                                result.add(value);
                                resultTupleEntry = new TupleEntry(FieldNames.TRANSIENT_INDEX_MESSAGE_PAIR_F, result);
                                functionCall.getOutputCollector().add(resultTupleEntry);
                            }
                        }
                    }
                }
            }
        }
    }
}
