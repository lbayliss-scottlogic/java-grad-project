package com.scottlogic.sort;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDate implements Sort {

    @Override
    public List<UserPost> sort(List<UserPost> inputList, SortOrder sortOrder) {
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
