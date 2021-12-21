package com.scottlogic.sort;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortContentLength implements Sort {

    private SortOrder sortOrder;

    public SortContentLength(SortOrder orderToSort) {
        sortOrder = orderToSort;
    }
    @Override
    public List<UserPost> sort(List<UserPost> inputList) {
        if (inputList == null) {
            return Arrays.asList();
        }
        if (SortOrder.ASC.equals(sortOrder)) {
            Collections.sort(inputList, Comparator.comparingInt(post -> post.getContents().length()));
        }
        else {
            Collections.sort(inputList, (post1, post2) -> post2.getContents().length() - post1.getContents().length());
        }
        return inputList;
    }
}
