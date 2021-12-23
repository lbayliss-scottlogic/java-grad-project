package com.scottlogic.sort;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAuthor implements Sort {

    private SortOrder sortOrder;

    public SortAuthor(SortOrder orderToSort) {
        sortOrder = orderToSort;
    }

    @Override
    public List<UserPost> sort(List<UserPost> inputList) {
        if (inputList == null) {
            return Arrays.asList();
        }
        if (SortOrder.ASC.equals(sortOrder)) {
            Collections.sort(inputList, Comparator.comparing(UserPost::getAuthor));
        }
        else {
            Collections.sort(inputList, Comparator.comparing(UserPost::getAuthor).reversed());
        }
        return inputList;
    }
}
