package com.scottlogic.SortingTests;

import com.scottlogic.SortContext;
import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;
import com.scottlogic.sort.SortAuthorSurname;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class AuthorSurnameSortingTests {
    UserPost userPost1 = new UserPost("Mick Jagger",
            OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC),
            "You got moves like me?", 2);

    UserPost userPost2 = new UserPost("Matt Damon",
            OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC),
            "How you like them apples?!", 1);

    UserPost userPost3 = new UserPost("Jane Austin Smith",
            OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC),
            "An example of a post \nwith lines breaks.", 3);

    UserPost userPost4 = new UserPost("Steve",
            OffsetDateTime.of(1997, 11, 14, 10, 50, 1, 0, ZoneOffset.UTC),
            "My name is Jeoff", 9);

    UserPost userPost5 = new UserPost("This funky-name",
            OffsetDateTime.of(2001, 1, 1, 1, 1, 1, 1, ZoneOffset.UTC),
            "funky funk funk", 10);

    List<UserPost> userPosts = Arrays.asList(userPost1, userPost2, userPost3, userPost4, userPost5);

    SortContext sortAuthorSurname = new SortContext(new SortAuthorSurname());

    @Test
    @DisplayName("ascending functionaltiy")
    void sortAuthorSurnameAscending() {
        List<UserPost> postsToSort = userPosts;
        List<UserPost> expectedSurnameSort = Arrays.asList(userPost4, userPost2, userPost5, userPost1, userPost3);
        Assertions.assertEquals(expectedSurnameSort, sortAuthorSurname.sortPosts(postsToSort, SortOrder.ASC));
    }

    @Test
    @DisplayName("descending functionaltiy")
    void sortAuthorSurnameDescending() {
        List<UserPost> postsToSort = userPosts;
        List<UserPost> expectedSurnameSort = Arrays.asList(userPost3, userPost1, userPost5, userPost2, userPost4);
        Assertions.assertEquals(expectedSurnameSort, sortAuthorSurname.sortPosts(postsToSort, SortOrder.DESC));
    }

    @Nested
    @DisplayName("Empty input")
    class sortAuthorSurname_emptyInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortAuthorSurname.sortPosts(emptyList, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortAuthorSurname.sortPosts(emptyList, SortOrder.DESC));
        }
    }

    @Nested
    @DisplayName("Null input")
    class sortAuthorSurname_nullInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_nullInput() {
            List<UserPost> nullInput = Arrays.asList();
            Assertions.assertEquals(nullInput, sortAuthorSurname.sortPosts(null, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            List<UserPost> nullInput = Arrays.asList();
            Assertions.assertEquals(nullInput, sortAuthorSurname.sortPosts(null, SortOrder.DESC));

        }
    }
}
