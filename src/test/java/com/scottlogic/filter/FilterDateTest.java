package com.scottlogic.filter;

import com.scottlogic.UserPost;
import com.scottlogic.utils.UserPostFilterData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FilterDateTest {

    FilterDateEquals dateEqualsFilterTest = new FilterDateEquals();
    FilterBetweenDates dateBetweenFilterTest = new FilterBetweenDates();

    @Nested
    @DisplayName("Date equals filter")
    class dateEqualsDate {
        @Test
        @DisplayName("functionality")
        void filterDateEqualsFunctionality() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredDateEquals();
            String filterDate = "2001-01-01T01:01:01Z";
            Assertions.assertEquals(expectedFilteredList, dateEqualsFilterTest.filter(postsToFilter, filterDate));
        }
    }

    @Nested
    @DisplayName("Between dates filter")
    class dateBetweenRange {
        @Test
        @DisplayName("functionality")
        void filterDateBetweenFunctionality() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredDateBetween();
            String filterDate = "2016-01-01T01:01:01Z 2021-01-01T01:01:01Z";
            Assertions.assertEquals(expectedFilteredList, dateBetweenFilterTest.filter(postsToFilter, filterDate));
        }

        @Test
        @DisplayName("reversed inputs")
        void filterDateBetween_reversedInputs() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredDateBetween_reversedInput();
            String filterDate = "2021-01-01T01:01:01Z 2016-01-01T01:01:01Z";
            Assertions.assertEquals(expectedFilteredList, dateBetweenFilterTest.filter(postsToFilter, filterDate));
        }

        @Test
        @DisplayName("equal to start date")
        void filterDateBetween_equalsStartDate() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredDateBetween_equalsStartDate();
            String filterDate = "2020-01-03T07:12:03Z 2021-01-01T01:01:01Z";
            Assertions.assertEquals(expectedFilteredList, dateBetweenFilterTest.filter(postsToFilter, filterDate));
        }

        @Test
        @DisplayName("equal to end date")
        void filterDateBetween_equalsEndDate() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredDateBetween_equalsEndDate();
            String filterDate = "2016-01-01T01:01:01Z 2021-03-12T13:22:12Z";
            Assertions.assertEquals(expectedFilteredList, dateBetweenFilterTest.filter(postsToFilter, filterDate));
        }
    }
}
