package com.scottlogic.SortingTests;

import com.scottlogic.context.SortContext;
import com.scottlogic.SortOrder;
import com.scottlogic.sort.SortAuthor;
import com.scottlogic.utils.UserPostSortData;
import com.scottlogic.UserPost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class AuthorSort {

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
            Assertions.assertEquals(Arrays.asList(), sortAuthor.sortPosts(null, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortAuthor.sortPosts(null, SortOrder.DESC));
        }
    }
}
