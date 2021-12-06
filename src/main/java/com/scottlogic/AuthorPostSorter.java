package com.scottlogic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AuthorPostSorter implements PostSorter {

    public List<UserPost> sort(List<UserPost> inputList) {
        if (inputList == null) {
            return Arrays.asList();
        }

        if (inputList.size() == 0) {
            return inputList;
        }
        Collections.sort(inputList, Comparator.comparing(UserPost::getAuthor));
        return inputList;
    }
}
