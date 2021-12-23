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

public class SortContentLengthTest {

    SortContentLength sortContentLengthAsc = new SortContentLength(SortOrder.ASC);
    SortContentLength sortContentLengthDesc = new SortContentLength(SortOrder.DESC);

    @Test
    @DisplayName("ascending functionality")
    void sortContentLengthAscending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedContentSort = UserPostSortData.getSortedContentLengthAscending();
        Assertions.assertEquals(expectedContentSort, sortContentLengthAsc.sort(postsToSort));
    }

    @Test
    @DisplayName("descending functionality")
    void sortContentLengthDescending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedContentSort = UserPostSortData.getSortedContentLengthDescending();
        Assertions.assertEquals(expectedContentSort, sortContentLengthDesc.sort(postsToSort));
    }

    @Nested
    @DisplayName("Empty input")
    class sortContentLength_EmptyInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortContentLengthAsc.sort(emptyList));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortContentLengthDesc.sort(emptyList));
        }
    }

    @Nested
    @DisplayName("Null input")
    class sort_authorNullInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortContentLengthAsc.sort(null));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortContentLengthDesc.sort(null));
        }
    }
}