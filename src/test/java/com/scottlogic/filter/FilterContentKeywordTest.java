package com.scottlogic.filter;

import com.scottlogic.UserPost;
import com.scottlogic.utils.UserPostFilterData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FilterContentKeywordTest {

    FilterContentKeyword filterContentKeyword = new FilterContentKeyword();

    @Test
    @DisplayName("Functionality with 'you'")
    void setFilterContentKeyword_you() {
        List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
        List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredContentKeyword_you();
        Assertions.assertEquals(expectedFilteredList, filterContentKeyword.filter(postsToFilter, "you"));
    }

    @Test
    @DisplayName("Functionality with 'You'")
    void setFilterContentKeyword_You() {
        List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
        List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredContentKeyword_You();
        Assertions.assertEquals(expectedFilteredList, filterContentKeyword.filter(postsToFilter, "You"));
    }

    @Test
    @DisplayName("Empty input")
    void filterContentKeyword_emptyInput() {
        Assertions.assertEquals(Arrays.asList(), filterContentKeyword.filter(Arrays.asList(), "steve"));
    }

    @Test
    @DisplayName("Null input")
    void filterContentKeyword_nullInput() {
        Assertions.assertEquals(Arrays.asList(), filterContentKeyword.filter(null, "steve"));
    }
}
