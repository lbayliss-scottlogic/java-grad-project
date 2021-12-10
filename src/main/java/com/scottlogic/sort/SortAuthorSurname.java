package com.scottlogic.sort;

import com.scottlogic.SortOrder;
import com.scottlogic.SortStrategy;
import com.scottlogic.UserPost;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAuthorSurname implements SortStrategy {
    @Override
    public List<UserPost> sort(List<UserPost> inputList, SortOrder sortOrder) {
        if (inputList == null) {
            return Arrays.asList();
        }
        // Split the input-list into two categories: (1) names with only 1 name (forename) and (2) names with 2 or more,
        // then sort each category and then append (2) onto the back of (1) for ascending sort
        List<UserPost> forenameList = new ArrayList<>();
        List<UserPost> fullnameList = new ArrayList<>();

        for (UserPost userPost : inputList) {
            String author = userPost.getAuthor();
            if (author.contains(" ")) {
                fullnameList.add(userPost);
            }
            else {
                forenameList.add(userPost);
            }
        }

        if (sortOrder.equals(SortOrder.ASC)) {
            Collections.sort(forenameList, Comparator.comparing(UserPost::getAuthor, String.CASE_INSENSITIVE_ORDER));
            Collections.sort(fullnameList, Comparator.comparing(UserPost::getAuthorSurname, String.CASE_INSENSITIVE_ORDER));
            return Stream.concat(forenameList.stream(), fullnameList.stream()).collect(Collectors.toList());
        }
        else {
            Collections.sort(forenameList, Comparator.comparing(UserPost::getAuthor, String.CASE_INSENSITIVE_ORDER).reversed());
            Collections.sort(fullnameList, Comparator.comparing(UserPost::getAuthorSurname, String.CASE_INSENSITIVE_ORDER).reversed());
            return Stream.concat(fullnameList.stream(), forenameList.stream()).collect(Collectors.toList());
        }
    }
}
