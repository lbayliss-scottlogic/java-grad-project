package com.scottlogic.sort;

import com.scottlogic.SortStrategy;
import com.scottlogic.UserPost;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortContentLengthAscending implements SortStrategy {
    @Override
    public List<UserPost> sort(List<UserPost> inputList) {
        if (inputList == null) {
            return Arrays.asList();
        }
        Collections.sort(inputList, (post1, post2) -> post1.getContents().length() - post2.getContents().length());
        return inputList;
    }
}
