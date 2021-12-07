package com.scottlogic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

class AuthorPostSorterTest {

    /*@Test
    @DisplayName("Ascending sort functionality")
    void sort_ascendingFunctionality() {
        PostSorter authorPostSorter = new AuthorPostSorter();
        UserPost userPost1 = new UserPost("Joe Bloggs",
                OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC),
                "Hello World!", 2);

        UserPost userPost2 = new UserPost("Matt Damon",
                OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC),
                "Another example post.", 1);

        UserPost userPost3 = new UserPost("Jane Smith",
                OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC),
                "An example of a post \nwith lines breaks.", 3);
        List<UserPost> unsortedInput = Arrays.asList(userPost1, userPost2, userPost3);
        List<UserPost> sortedInput = Arrays.asList(userPost3, userPost1, userPost2);
        Assertions.assertEquals(sortedInput, authorPostSorter.sort(unsortedInput, SortOrder.ASC));
    }

    @Test
    @DisplayName("Descending sort functionality")
    void sort_descendingFunctionality() {
        PostSorter authorPostSorter = new AuthorPostSorter();
        UserPost userPost1 = new UserPost("Joe Bloggs",
                OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC),
                "Hello World!", 2);

        UserPost userPost2 = new UserPost("Matt Damon",
                OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC),
                "Another example post.", 1);

        UserPost userPost3 = new UserPost("Jane Smith",
                OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC),
                "An example of a post \nwith lines breaks.", 3);
        List<UserPost> unsortedInput = Arrays.asList(userPost1, userPost2, userPost3);
        List<UserPost> sortedInput = Arrays.asList(userPost2, userPost1, userPost3);
        Assertions.assertEquals(sortedInput, authorPostSorter.sort(unsortedInput, SortOrder.DESC));
    }

    @Test
    @DisplayName("Empty input")
    void sort_emptyInput() {
        PostSorter authorPostSorter = new AuthorPostSorter();
        List<UserPost> emptyList = Arrays.asList();
        Assertions.assertEquals(emptyList, authorPostSorter.sort(emptyList, SortOrder.ASC));
    }

    @Test
    @DisplayName("Null input")
    void sort_nullInput() {
        PostSorter authorPostSorter = new AuthorPostSorter();
        List<UserPost> nullInput = Arrays.asList();
        Assertions.assertEquals(nullInput, authorPostSorter.sort(null, SortOrder.ASC));
    }*/
}