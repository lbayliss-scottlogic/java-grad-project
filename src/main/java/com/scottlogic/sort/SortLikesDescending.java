package com.scottlogic.sort;

import com.scottlogic.SortStrategy;
import com.scottlogic.UserPost;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortLikesDescending implements SortStrategy {
    @Override
    public List<UserPost> sort(List<UserPost> inputList) {
        Collections.sort(inputList, Comparator.comparing(UserPost::getLikeCount).reversed());
        return inputList;
    }
}
