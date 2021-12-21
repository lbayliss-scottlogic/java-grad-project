package com.scottlogic.filter.combined;

import com.scottlogic.UserPost;
import com.scottlogic.filter.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterAND implements Filter {

    private Filter firstFilter;
    private Filter secondFilter;

    public FilterAND(Filter filter1, Filter filter2) {
        firstFilter = filter1;
        secondFilter = filter2;
    }

    @Override
    public List<UserPost> filter(List<UserPost> inputList) {
        List<UserPost> outputList1 = firstFilter.filter(inputList);
        List<UserPost> outputList2 = secondFilter.filter(inputList);
        List<UserPost> andList = new ArrayList<>();

        for (UserPost userPost : outputList1) {
            if (outputList2.contains(userPost)) {
                andList.add(userPost);
            }
        }

        return andList;
    }
}
