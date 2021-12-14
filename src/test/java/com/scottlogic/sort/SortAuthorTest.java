package com.scottlogic.sort;

import com.scottlogic.SortOrder;
import com.scottlogic.utils.UserPostSortData;
import com.scottlogic.UserPost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class SortAuthorTest {

    SortAuthor sortAuthor = new SortAuthor();

    @Test
    @DisplayName("Ascending functionality")
    void sortAuthorAscending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedAuthorSort = UserPostSortData.getSortedAuthorAscendingList();
        Assertions.assertEquals(expectedAuthorSort, sortAuthor.sort(postsToSort, SortOrder.ASC));
    }

    @Test
    @DisplayName("Descending functionality")
    void sortAuthorDescending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedAuthorSort = UserPostSortData.getSortedAuthorDescendingList();
        Assertions.assertEquals(expectedAuthorSort, sortAuthor.sort(postsToSort, SortOrder.DESC));
    }

    @Nested
    @DisplayName("Empty input")
    class sortAuthor_EmptyInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortAuthor.sort(emptyList, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortAuthor.sort(emptyList, SortOrder.DESC));
        }
    }

    @Nested
    @DisplayName("Null input")
    class sortAuthor_NullInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortAuthor.sort(null, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortAuthor.sort(null, SortOrder.DESC));
        }
    }
}
