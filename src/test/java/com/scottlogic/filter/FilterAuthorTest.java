package com.scottlogic.filter;

import com.scottlogic.UserPost;
import com.scottlogic.utils.UserPostFilterData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FilterAuthorTest {

    @Test
    @DisplayName("Functionality with 'Steve'")
    void filterAuthorFunctionality_Steve() {
        FilterAuthor filterAuthor = new FilterAuthor("Steve");
        List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
        List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredAuthor_Steve();
        Assertions.assertEquals(expectedFilteredList, filterAuthor.filter(postsToFilter));
    }

    @Test
    @DisplayName("Functionality with 'steve'")
    void filterAuthorFunctionality_steve() {
        FilterAuthor filterAuthor = new FilterAuthor("steve");
        List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
        List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredAuthor_steve();
        Assertions.assertEquals(expectedFilteredList, filterAuthor.filter(postsToFilter));
    }

    @Test
    @DisplayName("Null input")
    void filterAuthor_nullInput() {
        FilterAuthor filterAuthor = new FilterAuthor("steve");
        Assertions.assertEquals(Arrays.asList(), filterAuthor.filter(null));
    }
}
