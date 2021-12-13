package com.scottlogic.SortingTests;

import com.scottlogic.context.SortContext;
import com.scottlogic.SortOrder;
import com.scottlogic.sort.SortAuthorSurname;
import com.scottlogic.utils.UserPostSortData;
import com.scottlogic.UserPost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AuthorSurnameSort {

    SortContext sortAuthorSurname = new SortContext(new SortAuthorSurname());

    @Test
    @DisplayName("ascending functionaltiy")
    void sortAuthorSurnameAscending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedSurnameSort = UserPostSortData.getSortedAuthorSurnameAscending();
        Assertions.assertEquals(expectedSurnameSort, sortAuthorSurname.sortPosts(postsToSort, SortOrder.ASC));
    }

    @Test
    @DisplayName("descending functionaltiy")
    void sortAuthorSurnameDescending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedSurnameSort = UserPostSortData.getSortedAuthorSurnameDescending();
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
            Assertions.assertEquals(Arrays.asList(), sortAuthorSurname.sortPosts(null, SortOrder.ASC));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortAuthorSurname.sortPosts(null, SortOrder.DESC));

        }
    }
}
