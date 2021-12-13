package com.scottlogic.FilterTests;

import com.scottlogic.UserPost;
import com.scottlogic.context.FilterContext;
import com.scottlogic.filter.FilterAuthor;
import com.scottlogic.utils.UserPostFilterData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AuthorFilter {

    FilterContext filterAuthor = new FilterContext(new FilterAuthor());

    @Test
    @DisplayName("Functionality with 'Steve'")
    void filterAuthorFunctionality_Steve() {
        List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
        List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredAuthor_Steve();
        Assertions.assertEquals(expectedFilteredList, filterAuthor.filterPosts(postsToFilter, "Steve"));
    }

    @Test
    @DisplayName("Functionality with 'steve'")
    void filterAuthorFunctionality_steve() {
        List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
        List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredAuthor_steve();
        Assertions.assertEquals(expectedFilteredList, filterAuthor.filterPosts(postsToFilter, "steve"));
    }
}
