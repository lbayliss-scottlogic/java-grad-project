package com.scottlogic.filter;

import com.scottlogic.UserPost;
import com.scottlogic.utils.UserPostFilterData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FilterDateTest {

    @Nested
    @DisplayName("Date equals filter")
    class dateEqualsDate {
        @Test
        @DisplayName("functionality")
        void filterDateEqualsFunctionality() {
            FilterDateEquals filterDateEquals = new FilterDateEquals("2001-01-01T01:01:01Z");
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredDateEquals();
            Assertions.assertEquals(expectedFilteredList, filterDateEquals.filter(postsToFilter));
        }

        @Test
        @DisplayName("Empty input")
        void filterDateEquals_emptyInput() {
            FilterDateEquals filterDateEquals = new FilterDateEquals("");
            Assertions.assertEquals(Arrays.asList(), filterDateEquals.filter(Arrays.asList()));
        }

        @Test
        @DisplayName("Null input")
        void filterDateEquals_nullInput() {
            FilterDateEquals filterDateEquals = new FilterDateEquals("");
            Assertions.assertEquals(Arrays.asList(), filterDateEquals.filter(null));
        }
    }

    @Nested
    @DisplayName("Between dates filter")
    class dateBetweenRange {
        @Test
        @DisplayName("functionality")
        void filterDateBetweenFunctionality() {
            FilterBetweenDates filterBetweenDates = new FilterBetweenDates("2016-01-01T01:01:01Z 2021-01-01T01:01:01Z");
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredDateBetween();
            Assertions.assertEquals(expectedFilteredList, filterBetweenDates.filter(postsToFilter));
        }

        @Test
        @DisplayName("reversed inputs")
        void filterDateBetween_reversedInputs() {
            FilterBetweenDates filterBetweenDates = new FilterBetweenDates("2021-01-01T01:01:01Z 2016-01-01T01:01:01Z");
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredDateBetween_reversedInput();
            Assertions.assertEquals(expectedFilteredList, filterBetweenDates.filter(postsToFilter));
        }

        @Test
        @DisplayName("equal to start date")
        void filterDateBetween_equalsStartDate() {
            FilterBetweenDates filterBetweenDates = new FilterBetweenDates("2020-01-03T07:12:03Z 2021-01-01T01:01:01Z");
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredDateBetween_equalsStartDate();
            Assertions.assertEquals(expectedFilteredList, filterBetweenDates.filter(postsToFilter));
        }

        @Test
        @DisplayName("equal to end date")
        void filterDateBetween_equalsEndDate() {
            FilterBetweenDates filterBetweenDates = new FilterBetweenDates("2016-01-01T01:01:01Z 2021-03-12T13:22:12Z");
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredDateBetween_equalsEndDate();
            Assertions.assertEquals(expectedFilteredList, filterBetweenDates.filter(postsToFilter));
        }

        @Test
        @DisplayName("Empty input")
        void filterDatesBetween_emptyInput() {
            FilterBetweenDates filterBetweenDates = new FilterBetweenDates("");
            Assertions.assertEquals(Arrays.asList(), filterBetweenDates.filter(Arrays.asList()));
        }

        @Test
        @DisplayName("Null input")
        void filterDateBetween_nullInput() {
            FilterBetweenDates filterBetweenDates = new FilterBetweenDates("");
            Assertions.assertEquals(Arrays.asList(), filterBetweenDates.filter(null));
        }
    }
}
