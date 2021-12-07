package com.scottlogic.sort;

import com.scottlogic.PostSorter;
import com.scottlogic.UserPost;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAuthorDescending implements PostSorter {

    @Override
    public List<UserPost> sort(List<UserPost> inputList) {
        Collections.sort(inputList, Comparator.comparing(UserPost::getAuthor).reversed());
        return inputList;
    }
}