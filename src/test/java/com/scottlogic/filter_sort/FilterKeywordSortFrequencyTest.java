package com.scottlogic.filter_sort;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;
import com.scottlogic.filter.Filter;
import com.scottlogic.sort.SortDate;
import com.scottlogic.utils.UserPostFilterData;
import com.scottlogic.utils.UserPostFilterSortData;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FilterKeywordSortFrequencyTest {

    @Nested
    @DisplayName("Functionality")
    class FilterKeywordSortFrequency_Functionality {
        @Test
        @DisplayName("1, 3, 2 ascending frequency")
        void filterKeywordFunky_sortFrequencyAsc() {
            List<UserPost> postsToFilter = UserPostFilterSortData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterSortData.getFilteredKeywordFunky_sortFrequencyAsc();
            FilterKeywordSortFrequency filterKeywordSortFrequency = new FilterKeywordSortFrequency(
                    "funky", SortOrder.ASC);
            Assertions.assertEquals(expectedFilteredList, filterKeywordSortFrequency.filter(postsToFilter));
        }

        @Test
        @DisplayName("1, 3, 2 descending frequency")
        void filterKeywordFunky_sortFrequencyDesc() {
            List<UserPost> postsToFilter = UserPostFilterSortData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterSortData.filterKeywordFunky_sortFrequencyDesc();
            FilterKeywordSortFrequency filterKeywordSortFrequency = new FilterKeywordSortFrequency(
                    "funky", SortOrder.DESC);
            Assertions.assertEquals(expectedFilteredList, filterKeywordSortFrequency.filter(postsToFilter));
        }

        @Test
        @DisplayName("1, 2, 1 ascending frequency")
        void filterKeywordYou_sortFrequencyAsc_sameCount() {
            List<UserPost> postsToFilter = UserPostFilterSortData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterSortData.filterKeywordYou_sortFrequencyAsc_sameCount();
            FilterKeywordSortFrequency filterKeywordSortFrequency = new FilterKeywordSortFrequency(
                    "you", SortOrder.ASC);
            Assertions.assertEquals(expectedFilteredList, filterKeywordSortFrequency.filter(postsToFilter));
        }

        @Test
        @DisplayName("no filter matches ascending frequency")
        void filterKeywordChess_sortFrequencyAsc_zeroCounts() {
            List<UserPost> postsToFilter = UserPostFilterSortData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterSortData.filterKeywordChess_sortFrequencyAsc_zeroCount();
            FilterKeywordSortFrequency filterKeywordSortFrequency = new FilterKeywordSortFrequency(
                    "Chess", SortOrder.ASC);
            Assertions.assertEquals(expectedFilteredList, filterKeywordSortFrequency.filter(postsToFilter));
        }
    }

    @Test
    @DisplayName("Empty input list")
    void filterKeyword_sortFrequencyAsc_emptyInputList() {
        FilterKeywordSortFrequency filterKeywordSortFrequency = new FilterKeywordSortFrequency("You", SortOrder.ASC);
        Assertions.assertEquals(Arrays.asList(), filterKeywordSortFrequency.filter(Arrays.asList()));
    }

    @Test
    @DisplayName("Null input list")
    void filterKeyword_sortFrequencyAsc_nullInputList() {
        FilterKeywordSortFrequency filterKeywordSortFrequency = new FilterKeywordSortFrequency("You", SortOrder.ASC);
        Assertions.assertEquals(null, filterKeywordSortFrequency.filter(null));
    }

    @Test
    @DisplayName("Null filter word")
    void filterKeywordNull_sortFrequencyAsc() {
        List<UserPost> postsToFilter = UserPostFilterSortData.getUnfilteredData();
        FilterKeywordSortFrequency filterKeywordSortFrequency = new FilterKeywordSortFrequency(null, SortOrder.ASC);
        Assertions.assertEquals(null, filterKeywordSortFrequency.filter(postsToFilter));
    }

    @Test
    @DisplayName("Null filter sort-order")
    void filterKeywordSteve_sortFrequency_nullSortOrder() {
        List<UserPost> postsToFilter = UserPostFilterSortData.getUnfilteredData();
        FilterKeywordSortFrequency filterKeywordSortFrequency = new FilterKeywordSortFrequency("Steve", null);
        Assertions.assertEquals(null, filterKeywordSortFrequency.filter(postsToFilter));
    }
}
