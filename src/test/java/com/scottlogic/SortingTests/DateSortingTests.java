package com.scottlogic.SortingTests;

import com.scottlogic.SortContext;
import com.scottlogic.UserPost;
import com.scottlogic.sort.SortDateAscending;
import com.scottlogic.sort.SortDateDescending;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class DateSortingTests {
    UserPost userPost1 = new UserPost("Mick Jagger",
            OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC),
            "You got moves like me?", 2);

    UserPost userPost2 = new UserPost("Matt Damon",
            OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC),
            "How you like them apples?!", 1);

    UserPost userPost3 = new UserPost("Jane Smith",
            OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC),
            "An example of a post \nwith lines breaks.", 3);
    List<UserPost> userPosts = Arrays.asList(userPost1, userPost2, userPost3);

    SortContext sortDateAscending = new SortContext(new SortDateAscending());
    SortContext sortDateDescending = new SortContext(new SortDateDescending());

    @Test
    @DisplayName("Ascending functionality")
    void sortDateAscending() {
        List<UserPost> postsToSort = userPosts;
        List<UserPost> expectedDateSort = Arrays.asList(userPost1, userPost2, userPost3);
        Assertions.assertEquals(expectedDateSort, sortDateAscending.sortPosts(postsToSort));
    }

    @Test
    @DisplayName("Descending functionality")
    void sortDateDescending() {
        List<UserPost> postsToSort = userPosts;
        List<UserPost> expectedDateSort = Arrays.asList(userPost3, userPost2, userPost1);
        Assertions.assertEquals(expectedDateSort, sortDateDescending.sortPosts(postsToSort));
    }

    @Nested
    @DisplayName("Empty input")
    class sortDate_EmptyInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortDateAscending.sortPosts(emptyList));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortDateDescending.sortPosts(emptyList));
        }
    }

    @Nested
    @DisplayName("Null input")
    class sortDate_NullInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_nullInput() {
            List<UserPost> nullInput = Arrays.asList();
            Assertions.assertEquals(nullInput, sortDateAscending.sortPosts(null));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            List<UserPost> nullInput = Arrays.asList();
            Assertions.assertEquals(nullInput, sortDateDescending.sortPosts(null));
        }
    }
}
