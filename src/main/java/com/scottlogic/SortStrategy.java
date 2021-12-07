package com.scottlogic;

import java.util.List;

public class SortStrategy {
    public PostSorter sortingMethod;

    public SortStrategy(PostSorter sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    public List<UserPost> sortPosts(List<UserPost> inputList) {
        return sortingMethod.sort(inputList);
    }
}
