package com.scottlogic.filter;

import com.scottlogic.strategy.Filter;
import com.scottlogic.UserPost;

import java.util.ArrayList;
import java.util.List;

public class FilterAuthor implements Filter {

    @Override
    public List<UserPost> filter(List<UserPost> inputList, String filterCriteria) {
        List<UserPost> outputList = new ArrayList<>(inputList);
        outputList.removeIf(a -> !a.getAuthor().contains(filterCriteria));
        return outputList;
    }
}
