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

public class SortLikeCountTest {

    SortLikes sortLikesAsc = new SortLikes(SortOrder.ASC);
    SortLikes sortLikesDesc = new SortLikes(SortOrder.DESC);

    @Test
    @DisplayName("ascending functionality")
    void sortLikesAscending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedLikeSort = UserPostSortData.getSortedLikesAscendingList();
        Assertions.assertEquals(expectedLikeSort, sortLikesAsc.sort(postsToSort));
    }

    @Test
    @DisplayName("descending functionality")
    void sortLikesDescending() {
        List<UserPost> postsToSort = UserPostSortData.getUnsortedList();
        List<UserPost> expectedLikesSort = UserPostSortData.getSortedLikesDescendingList();
        Assertions.assertEquals(expectedLikesSort, sortLikesDesc.sort(postsToSort));
    }

    @Nested
    @DisplayName("Empty input")
    class sortLikes_EmptyInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortLikesAsc.sort(emptyList));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_emptyInput() {
            List<UserPost> emptyList = Arrays.asList();
            Assertions.assertEquals(emptyList, sortLikesDesc.sort(emptyList));
        }
    }

    @Nested
    @DisplayName("Null input")
    class sortLikes_NullInput {
        @Test
        @DisplayName("ascending sort")
        void sortAscending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortLikesAsc.sort(null));
        }

        @Test
        @DisplayName("descending sort")
        void sortDescending_nullInput() {
            Assertions.assertEquals(Arrays.asList(), sortLikesDesc.sort(null));
        }
    }
}
