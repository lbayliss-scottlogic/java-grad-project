package com.scottlogic.sort;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAuthorSurname implements Sort {

    private SortOrder sortOrder;

    public SortAuthorSurname(SortOrder orderToSort) {
        sortOrder = orderToSort;
    }

    /**
     * Split the input-list into two categories: (1) names with only 1 name (forename) and (2) names with 2 or more,
     * then sort each category and then append (2) onto the back of (1) for ascending sort
     * @param inputList List of user post (author, date, content, likes) that need sorting
     */
    @Override
    public List<UserPost> sort(List<UserPost> inputList) {
        if (inputList == null) {
            return Arrays.asList();
        }
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

        if (SortOrder.ASC.equals(sortOrder)) {
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
