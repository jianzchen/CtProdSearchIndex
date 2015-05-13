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
 * parse the image status, attr_id = 1
 * One record to multiple records
 * Author: Johnson CHEN
 * Date: 2014/11/28
 */


public class ProdImageStatusFunc extends BaseOperation
        implements Function {

    public ProdImageStatusFunc(Fields newFields) {
        super(ANY, newFields);
    }

    @Override
    public void operate(FlowProcess flowProcess, FunctionCall functionCall) {
        TupleEntry argument = functionCall.getArguments();

        Tuple result = new Tuple();
        TupleEntry resultTupleEntry;
        String[] input;
        int seqNum = 1;

        /* INDEX_MESSAGE */
        for (int i = 0; i < argument.size(); i++) {
            if (argument.getString(i) != null && !argument.getString(i).equals("")) {
                input = argument.getString(i).split("\\|");
                for (String ss : input) {
                    String[] sss = ss.trim().split("\\s", 3);
                    if (sss.length >= 3)
                    {
                        String id = sss[0];
                        String afterId = sss[1];
                        String[] attrValues = sss[2].trim().split("\\s");
                        if (id.equals("1") && afterId.matches("TXT,ST.*") ) {
                            for (String value : attrValues) {
                                result.clear();
                                result.add(value);
                                result.add(seqNum++);
                                resultTupleEntry = new TupleEntry(FieldNames.PROD_IMAGE_STATUS, result);
                                functionCall.getOutputCollector().add(resultTupleEntry);
                            }
                        }
                    }
                }
            }
        }
        if (seqNum == 1) {
            result.clear();
            result.add("");
            result.add(seqNum);
            resultTupleEntry = new TupleEntry(FieldNames.PROD_IMAGE_STATUS, result);
            functionCall.getOutputCollector().add(resultTupleEntry);
        }
    }
}
