package com.scottlogic.sort;

import com.scottlogic.PostSorter;
import com.scottlogic.UserPost;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAuthorAscending implements PostSorter {

    @Override
    public List<UserPost> sort(List<UserPost> inputList) {
        Collections.sort(inputList, Comparator.comparing(UserPost::getAuthor));
        return inputList;
    }
}
