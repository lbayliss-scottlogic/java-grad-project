package com.scottlogic.SortingTests;

import com.scottlogic.SortContext;
import com.scottlogic.SortOrder;
import com.scottlogic.SortingTests.utils.UserPostSortData;
import com.scottlogic.UserPost;
import com.scottlogic.sort.SortDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DateSortingTests {

    SortContext sortDate = new SortContext(new SortDate());

    @Test
    @DisplayName("Ascending functionality")
    void sortDateAscending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedDateSort = UserPostSortData.getSortedDateAscendingList();
        Assertions.assertEquals(expectedDateSort, sortDate.sortPosts(postsToSort, SortOrder.ASC));
    }

    @Test
    @DisplayName("Descending functionality")
    void sortDateDescending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedDateSort = UserPostSortData.getSortedDateDescendingList();
        Assertions.assertEquals(expectedDateSort, sortDate.sortPosts(postsToSort, SortOrder.DESC));
    }

    @Nested
    @DisplayName("Empty input")
    class sortDate_EmptyInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortDate.sortPosts(emptyList, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortDate.sortPosts(emptyList, SortOrder.DESC));
        }
    }

    @Nested
    @DisplayName("Null input")
    class sortDate_NullInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_nullInput() {
            List<UserPost> nullInput = Arrays.asList();
            Assertions.assertEquals(nullInput, sortDate.sortPosts(null, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            List<UserPost> nullInput = Arrays.asList();
            Assertions.assertEquals(nullInput, sortDate.sortPosts(null, SortOrder.DESC));
        }
    }
}