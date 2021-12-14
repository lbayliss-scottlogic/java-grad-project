package com.scottlogic.filter;

import com.scottlogic.UserPost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterAuthor implements Filter {

    @Override
    public List<UserPost> filter(List<UserPost> inputList, String filterCriteria) {
        if (inputList == null) {
            return Arrays.asList();
        }
        List<UserPost> outputList = new ArrayList<>(inputList);
        outputList.removeIf(a -> !a.getAuthor().contains(filterCriteria));
        return outputList;
    }
}
