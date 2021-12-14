package com.scottlogic.filter;

import com.scottlogic.UserPost;
import com.scottlogic.utils.UserPostFilterData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FilterLikedPostsTest {

    FilterLikedPosts filterLikedPosts = new FilterLikedPosts();

    @Test
    @DisplayName("Functionality")
    void filterLikedPostsFunctionality() {
        List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
        List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredLikedPosts();
        Assertions.assertEquals(expectedFilteredList, filterLikedPosts.filter(postsToFilter, null));
    }

    @Test
    @DisplayName("Empty input")
    void filterLikedPosts_emptyInput() {
        Assertions.assertEquals(Arrays.asList(), filterLikedPosts.filter(Arrays.asList(), "steve"));
    }

    @Test
    @DisplayName("Null input")
    void filterLikedPosts_nullInput() {
        Assertions.assertEquals(Arrays.asList(), filterLikedPosts.filter(null, "steve"));
    }
}
