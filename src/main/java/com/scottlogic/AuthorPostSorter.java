package com.scottlogic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AuthorPostSorter implements PostSorter {

    public List<UserPost> sort(List<UserPost> inputList, SortOrder sortDirection) {
        if (inputList == null || inputList.size() == 0) {
            return Arrays.asList();
        }

        if (sortDirection == SortOrder.ASC) {
            Collections.sort(inputList, Comparator.comparing(UserPost::getAuthor));
        }
        else if (sortDirection == SortOrder.DESC) {
            Collections.sort(inputList, Comparator.comparing(UserPost::getAuthor).reversed());
        }

        return inputList;
    }
}
