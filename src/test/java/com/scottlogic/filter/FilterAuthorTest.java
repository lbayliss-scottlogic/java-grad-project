package com.scottlogic.filter;

import com.scottlogic.UserPost;
import com.scottlogic.utils.UserPostFilterData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FilterAuthorTest {

    FilterAuthor filterAuthor = new FilterAuthor();

    @Test
    @DisplayName("Functionality with 'Steve'")
    void filterAuthorFunctionality_Steve() {
        List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
        List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredAuthor_Steve();
        Assertions.assertEquals(expectedFilteredList, filterAuthor.filter(postsToFilter, "Steve"));
    }

    @Test
    @DisplayName("Functionality with 'steve'")
    void filterAuthorFunctionality_steve() {
        List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
        List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredAuthor_steve();
        Assertions.assertEquals(expectedFilteredList, filterAuthor.filter(postsToFilter, "steve"));
    }



    @Test
    @DisplayName("Null input")
    void filterAuthor_nullInput() {
        Assertions.assertEquals(Arrays.asList(), filterAuthor.filter(null, "steve"));
    }
}
