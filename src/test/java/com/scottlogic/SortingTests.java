package com.scottlogic;

import com.scottlogic.sort.*;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

class SortingTests {

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

    @Nested
    @DisplayName("Ascending sort functionality")
    class sort_ascendingFunctionality {

        @Test
        @DisplayName("Author")
        void sortAuthorAscending() {
            List<UserPost> postsToSort = userPosts;
            SortContext sortAuthorAscending = new SortContext(new SortAuthorAscending());
            List<UserPost> expectedAuthorSort = Arrays.asList(userPost3, userPost2, userPost1);
            Assertions.assertEquals(expectedAuthorSort, sortAuthorAscending.sortPosts(postsToSort));
        }

        @Test
        @DisplayName("Date")
        void sortDateAscending() {
            List<UserPost> postsToSort = userPosts;
            SortContext sortDateAscending = new SortContext(new SortDateAscending());
            List<UserPost> expectedDateSort = Arrays.asList(userPost1, userPost2, userPost3);
            Assertions.assertEquals(expectedDateSort, sortDateAscending.sortPosts(postsToSort));
        }

        @Test
        @DisplayName("Number of likes")
        void sortLikesAscending() {
            List<UserPost> postsToSort = userPosts;
            SortContext sortLikesAscending = new SortContext(new SortLikesAscending());
            List<UserPost> expectedLikeSort = Arrays.asList(userPost2, userPost1, userPost3);
            Assertions.assertEquals(expectedLikeSort, sortLikesAscending.sortPosts(postsToSort));
        }

        @Test
        @DisplayName("Content length")
        void sortContentLengthAscending() {
            List<UserPost> postsToSort = userPosts;
            SortContext sortContentLengthAscending = new SortContext(new SortContentLengthAscending());
            List<UserPost> expectedContentSort = Arrays.asList(userPost1, userPost2, userPost3);
            Assertions.assertEquals(expectedContentSort, sortContentLengthAscending.sortPosts(postsToSort));
        }
    }

    @Nested
    @DisplayName("Descending sort functionality")
    class sort_descendingFunctionality {

        @Test
        @DisplayName("Author")
        void sortAuthorDescending() {
            List<UserPost> postsToSort = userPosts;
            SortContext sortAuthorDescending = new SortContext(new SortAuthorDescending());
            List<UserPost> expectedAuthorSort = Arrays.asList(userPost1, userPost2, userPost3);
            Assertions.assertEquals(expectedAuthorSort, sortAuthorDescending.sortPosts(postsToSort));
        }

        @Test
        @DisplayName("Date")
        void sortDateDescending() {
            List<UserPost> postsToSort = userPosts;
            SortContext sortDateDescending = new SortContext(new SortDateDescending());
            List<UserPost> expectedDateSort = Arrays.asList(userPost3, userPost2, userPost1);
            Assertions.assertEquals(expectedDateSort, sortDateDescending.sortPosts(postsToSort));
        }

        @Test
        @DisplayName("Number of likes")
        void sortLikesDescending() {
            List<UserPost> postsToSort = userPosts;
            SortContext sortLikesDescending = new SortContext(new SortLikesDescending());
            List<UserPost> expectedLikesSort = Arrays.asList(userPost3, userPost1, userPost2);
            Assertions.assertEquals(expectedLikesSort, sortLikesDescending.sortPosts(postsToSort));
        }

        @Test
        @DisplayName("Content length")
        void sortContentLengthDescending() {
            List<UserPost> postsToSort = userPosts;
            SortContext sortContentDescending = new SortContext(new SortContentLengthDescending());
            List<UserPost> expectedContentSort = Arrays.asList(userPost3, userPost2, userPost1);
            Assertions.assertEquals(expectedContentSort, sortContentDescending.sortPosts(postsToSort));
        }
    }
}