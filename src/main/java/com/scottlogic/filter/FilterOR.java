package com.scottlogic.filter;

import com.scottlogic.UserPost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Set<UserPost> orList = new HashSet<>();
        for (UserPost userPost : outputList1) {
            orList.add(userPost);
        }
        for (UserPost userPost : outputList2) {
            orList.add(userPost);
        }
        /*List<UserPost> outputList2copy = new ArrayList<>(outputList2);
        outputList2copy.removeAll(outputList1);
        outputList1.addAll(outputList2copy);*/

        return new ArrayList<>(orList);
    }
}
