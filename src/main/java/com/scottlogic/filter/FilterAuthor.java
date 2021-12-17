package com.scottlogic.filter;

import com.scottlogic.UserPost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterAuthor implements Filter {

    private String filterCriteria;

    public FilterAuthor(String filterBy) {
        filterCriteria = filterBy;
    }

    @Override
    public List<UserPost> filter(List<UserPost> inputList) {
        if (inputList == null) {
            return Arrays.asList();
        }
        List<UserPost> outputList = new ArrayList<>(inputList);
        outputList.removeIf(a -> !a.getAuthor().contains(filterCriteria));
        return outputList;
    }
}
