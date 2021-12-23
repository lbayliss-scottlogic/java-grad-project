package com.scottlogic.sort;

import com.scottlogic.SortOrder;
import com.scottlogic.utils.UserPostSortData;
import com.scottlogic.UserPost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortAuthorSurnameTest {

    SortAuthorSurname sortAuthorSurnameAsc = new SortAuthorSurname(SortOrder.ASC);
    SortAuthorSurname sortAuthorSurnameDesc = new SortAuthorSurname(SortOrder.DESC);

    @Test
    @DisplayName("ascending functionaltiy")
    void sortAuthorSurnameAscending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedSurnameSort = UserPostSortData.getSortedAuthorSurnameAscending();
        Assertions.assertEquals(expectedSurnameSort, sortAuthorSurnameAsc.sort(postsToSort));
    }

    @Test
    @DisplayName("descending functionaltiy")
    void sortAuthorSurnameDescending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedSurnameSort = UserPostSortData.getSortedAuthorSurnameDescending();
        Assertions.assertEquals(expectedSurnameSort, sortAuthorSurnameDesc.sort(postsToSort));
    }

    @Nested
    @DisplayName("Empty input")
    class sortAuthorSurname_emptyInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortAuthorSurnameAsc.sort(emptyList));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortAuthorSurnameDesc.sort(emptyList));
        }
    }

    @Nested
    @DisplayName("Null input")
    class sortAuthorSurname_nullInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortAuthorSurnameAsc.sort(null));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
                Assertions.assertEquals(Arrays.asList(), sortAuthorSurnameDesc.sort(null));
        }
    }
}
