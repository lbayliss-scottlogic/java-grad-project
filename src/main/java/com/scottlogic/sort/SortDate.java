package com.scottlogic.sort;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDate implements Sort {

    private SortOrder sortOrder;

    public SortDate(SortOrder orderToSort) {
        sortOrder = orderToSort;
    }

    @Override
    public List<UserPost> sort(List<UserPost> inputList) {
        if (inputList == null) {
            return Arrays.asList();
        }
        if (SortOrder.ASC.equals(sortOrder)) {
            Collections.sort(inputList, Comparator.comparing(UserPost::getDateTime));
        }
        else {
            Collections.sort(inputList, Comparator.comparing(UserPost::getDateTime).reversed());
        }
        return inputList;
    }
}
