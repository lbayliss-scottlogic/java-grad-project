package com.scottlogic.SortingTests;

import com.scottlogic.SortContext;
import com.scottlogic.SortOrder;
import com.scottlogic.SortingTests.utils.UserPostSortData;
import com.scottlogic.UserPost;
import com.scottlogic.sort.SortAuthor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class AuthorSortingTests {

    SortContext sortAuthor = new SortContext(new SortAuthor());

    @Test
    @DisplayName("Ascending functionality")
    void sortAuthorAscending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedAuthorSort = UserPostSortData.getSortedAuthorAscendingList();
        Assertions.assertEquals(expectedAuthorSort, sortAuthor.sortPosts(postsToSort, SortOrder.ASC));
    }

    @Test
    @DisplayName("Descending functionality")
    void sortAuthorDescending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedAuthorSort = UserPostSortData.getSortedAuthorDescendingList();
        Assertions.assertEquals(expectedAuthorSort, sortAuthor.sortPosts(postsToSort, SortOrder.DESC));
    }

    @Nested
    @DisplayName("Empty input")
    class sortAuthor_EmptyInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortAuthor.sortPosts(emptyList, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortAuthor.sortPosts(emptyList, SortOrder.DESC));
        }
    }

    @Nested
    @DisplayName("Null input")
    class sortAuthor_NullInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_nullInput() {
            List<UserPost> nullInput = Arrays.asList();
            Assertions.assertEquals(nullInput, sortAuthor.sortPosts(null, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            List<UserPost> nullInput = Arrays.asList();
            Assertions.assertEquals(nullInput, sortAuthor.sortPosts(null, SortOrder.DESC));
        }
    }
}
