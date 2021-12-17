package com.scottlogic.filter;

import com.scottlogic.UserPost;
import com.scottlogic.utils.UserPostFilterData;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FilterContentKeywordTest {

    @Nested
    @DisplayName("Functionality with")
    class filterContentKeyword_functionality {
        @Test
        @DisplayName("keyword: 'you'")
        void setFilterContentKeyword_you() {
            FilterContentKeyword filterContentKeyword = new FilterContentKeyword("you");
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredContentKeyword_you();
            Assertions.assertEquals(expectedFilteredList, filterContentKeyword.filter(postsToFilter));
        }

        @Test
        @DisplayName("keyword: 'You'")
        void setFilterContentKeyword_You() {
            FilterContentKeyword filterContentKeyword = new FilterContentKeyword("You");
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredContentKeyword_You();
            Assertions.assertEquals(expectedFilteredList, filterContentKeyword.filter(postsToFilter));
        }

        @Test
        @DisplayName("keyword: 'yuo'")
        void setFilterContentKeyword_yuo() {
            FilterContentKeyword filterContentKeyword = new FilterContentKeyword("yuo");
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredContentKeyword_yuo();
            Assertions.assertEquals(expectedFilteredList, filterContentKeyword.filter(postsToFilter));
        }

        @Test
        @DisplayName("keyword: 'Funky funky")
        void setFilterContentKeyword_Funky_funky() {
            FilterContentKeyword filterContentKeyword = new FilterContentKeyword("Funky funky");
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredContentKeyword_Funky_funky();
            Assertions.assertEquals(expectedFilteredList, filterContentKeyword.filter(postsToFilter));
        }

        @Test
        @DisplayName("numbers")
        void setFilterContentKeyword_number() {
            FilterContentKeyword filterContentKeyword = new FilterContentKeyword("1");
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredContentKeyword_number_1();
            Assertions.assertEquals(expectedFilteredList, filterContentKeyword.filter(postsToFilter));
        }

        @Test
        @DisplayName("special character ?")
        void setFilterContentKeyword_special_character() {
            FilterContentKeyword filterContentKeyword = new FilterContentKeyword("?");
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredContentKeyword_special_character();
            Assertions.assertEquals(expectedFilteredList, filterContentKeyword.filter(postsToFilter));
        }
    }

    @Test
    @DisplayName("Empty input")
    void filterContentKeyword_emptyInput() {
        FilterContentKeyword filterContentKeyword = new FilterContentKeyword("steve");
        Assertions.assertEquals(Arrays.asList(), filterContentKeyword.filter(Arrays.asList()));
    }

    @Test
    @DisplayName("Null input")
    void filterContentKeyword_nullInput() {
        FilterContentKeyword filterContentKeyword = new FilterContentKeyword("steve");
        Assertions.assertEquals(Arrays.asList(), filterContentKeyword.filter(null));
    }
}
