package com.ebay.dss.operation;

import cascading.flow.FlowProcess;
import cascading.operation.BaseOperation;
import cascading.operation.Filter;
import cascading.operation.FilterCall;
import cascading.tuple.TupleEntry;

public class ColumnFilter extends BaseOperation implements Filter {

    String[] conditionArr;

    public ColumnFilter(String[] conditionArr) {
        super();
        this.conditionArr=conditionArr;
    }


    @Override
    public boolean isRemove(FlowProcess flowProcess, FilterCall filterCall) {
        TupleEntry arguments = filterCall.getArguments();
        String column = arguments.getString(0);
        for ( String s : conditionArr ) {
            if (column.equalsIgnoreCase(s)) return false;
        }
        return true;
    }
}
