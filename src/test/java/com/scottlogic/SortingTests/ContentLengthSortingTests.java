package com.scottlogic.SortingTests;

import com.scottlogic.SortContext;
import com.scottlogic.SortOrder;
import com.scottlogic.SortingTests.utils.UserPostSortData;
import com.scottlogic.UserPost;
import com.scottlogic.sort.SortContentLength;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ContentLengthSortingTests {

    SortContext sortContentLength = new SortContext(new SortContentLength());

    @Test
    @DisplayName("ascending functionality")
    void sortContentLengthAscending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedContentSort = UserPostSortData.getSortedContentLengthAscending();
        Assertions.assertEquals(expectedContentSort, sortContentLength.sortPosts(postsToSort, SortOrder.ASC));
    }

    @Test
    @DisplayName("descending functionality")
    void sortContentLengthDescending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedContentSort = UserPostSortData.getSortedContentLengthDescending();
        Assertions.assertEquals(expectedContentSort, sortContentLength.sortPosts(postsToSort, SortOrder.DESC));
    }

    @Nested
    @DisplayName("Empty input")
    class sortContentLength_EmptyInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortContentLength.sortPosts(emptyList, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortContentLength.sortPosts(emptyList, SortOrder.DESC));
        }
    }

    @Nested
    @DisplayName("Null input")
    class sort_authorNullInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_nullInput() {
            List<UserPost> nullInput = Arrays.asList();
            Assertions.assertEquals(nullInput, sortContentLength.sortPosts(null, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            List<UserPost> nullInput = Arrays.asList();
            Assertions.assertEquals(nullInput, sortContentLength.sortPosts(null, SortOrder.DESC));

        }
    }
}