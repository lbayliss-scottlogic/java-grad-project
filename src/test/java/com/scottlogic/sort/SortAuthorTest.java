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

    SortAuthor sortAuthorAsc = new SortAuthor(SortOrder.ASC);
    SortAuthor sortAuthorDesc = new SortAuthor(SortOrder.DESC);

    @Test
    @DisplayName("Ascending functionality")
    void sortAuthorAscending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedAuthorSort = UserPostSortData.getSortedAuthorAscendingList();
        Assertions.assertEquals(expectedAuthorSort, sortAuthorAsc.sort(postsToSort));
    }

    @Test
    @DisplayName("Descending functionality")
    void sortAuthorDescending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedAuthorSort = UserPostSortData.getSortedAuthorDescendingList();
        Assertions.assertEquals(expectedAuthorSort, sortAuthorDesc.sort(postsToSort));
    }

    @Nested
    @DisplayName("Empty input")
    class sortAuthor_EmptyInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortAuthorAsc.sort(emptyList));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortAuthorDesc.sort(emptyList));
        }
    }

    @Nested
    @DisplayName("Null input")
    class sortAuthor_NullInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortAuthorAsc.sort(null));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortAuthorDesc.sort(null));
        }
    }
}
