package com.scottlogic;

import java.util.List;

public class SortContext {
    public SortStrategy sortingMethod;

    public SortContext(SortStrategy sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    public List<UserPost> sortPosts(List<UserPost> inputList) {
        return sortingMethod.sort(inputList);
    }
}