package com.scottlogic.filter;

import com.scottlogic.UserPost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterOR implements Filter {

    private Filter firstFilter;
    private Filter secondFilter;

    public FilterOR(Filter filter1, Filter filter2) {
        firstFilter = filter1;
        secondFilter = filter2;
    }

    @Override
    public List<UserPost> filter(List<UserPost> inputList) {
        if (inputList == null) {
            return Arrays.asList();
        }
        List<UserPost> outputList1 = firstFilter.filter(inputList);
        List<UserPost> outputList2 = secondFilter.filter(inputList);

        List<UserPost> outputList2copy = new ArrayList<>(outputList2);
        outputList2copy.removeAll(outputList1);
        outputList1.addAll(outputList2copy);

        return outputList1;
    }
}
