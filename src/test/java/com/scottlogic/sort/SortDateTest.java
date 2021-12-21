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

public class SortDateTest {

    SortDate sortDateAsc = new SortDate(SortOrder.ASC);
    SortDate sortDateDesc = new SortDate(SortOrder.DESC);

    @Test
    @DisplayName("Ascending functionality")
    void sortDateAscending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedDateSort = UserPostSortData.getSortedDateAscendingList();
        Assertions.assertEquals(expectedDateSort, sortDateAsc.sort(postsToSort));
    }

    @Test
    @DisplayName("Descending functionality")
    void sortDateDescending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedDateSort = UserPostSortData.getSortedDateDescendingList();
        Assertions.assertEquals(expectedDateSort, sortDateDesc.sort(postsToSort));
    }

    @Nested
    @DisplayName("Empty input")
    class sortDate_EmptyInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortDateAsc.sort(emptyList));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortDateDesc.sort(emptyList));
        }
    }

    @Nested
    @DisplayName("Null input")
    class sortDate_NullInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortDateAsc.sort(null));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortDateDesc.sort(null));
        }
    }
}
