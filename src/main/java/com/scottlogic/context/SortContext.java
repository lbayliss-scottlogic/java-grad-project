package com.scottlogic.context;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;
import com.scottlogic.strategy.Sort;

import java.util.List;

public class SortContext {
    public Sort sortingMethod;

    public SortContext(Sort sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    public List<UserPost> sortPosts(List<UserPost> inputList, SortOrder sortOrder) {
        return sortingMethod.sort(inputList, sortOrder);
    }
}
