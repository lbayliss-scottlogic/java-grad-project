package com.scottlogic.sort;

import com.scottlogic.SortStrategy;
import com.scottlogic.UserPost;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortContentLengthAscending implements SortStrategy {
    @Override
    public List<UserPost> sort(List<UserPost> inputList) {
        Collections.sort(inputList, new Comparator<UserPost> () {
            public int compare(UserPost post1, UserPost post2) {
                return post1.getContents().length() - post2.getContents().length();
            }
        });
        return inputList;
    }
}
