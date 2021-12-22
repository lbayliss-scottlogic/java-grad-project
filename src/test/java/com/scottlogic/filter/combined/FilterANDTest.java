package com.scottlogic.filter.combined;

import com.scottlogic.UserPost;
import com.scottlogic.filter.Filter;
import com.scottlogic.filter.combined.FilterAND;
import com.scottlogic.filter.FilterAuthor;
import com.scottlogic.filter.FilterBetweenDates;
import com.scottlogic.filter.FilterContentKeyword;
import com.scottlogic.filter.FilterLikedPosts;
import com.scottlogic.utils.UserPostFilterData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.scottlogic.utils.UserPostFilterData.USER_POST_1;
import static com.scottlogic.utils.UserPostFilterData.USER_POST_2;
import static com.scottlogic.utils.UserPostFilterData.USER_POST_3;
import static com.scottlogic.utils.UserPostFilterData.USER_POST_4;
import static com.scottlogic.utils.UserPostFilterData.USER_POST_6;


public class FilterANDTest {

    @Nested
    @DisplayName("Author: 'Matt' AND ...")
    class AuthorAND_functionaltiy {

        Filter filterAuthor_Matt = new FilterAuthor("Matt");

        @Test
        @DisplayName("content keyword: you")
        void filterAuthorMatt_AND_keyword_you() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList(USER_POST_2);
            FilterAND filterAND = new FilterAND(filterAuthor_Matt, new FilterContentKeyword("you"));
            Assertions.assertEquals(expectedFilteredList, filterAND.filter(postsToFilter));
        }

        @Test
        @DisplayName("liked posts")
        void filterAuthorMatt_AND_likedPosts() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = Arrays.asList();
            FilterAND filterAND = new FilterAND(filterAuthor_Matt, new FilterLikedPosts());
            Assertions.assertEquals(expectedFitleredList, filterAND.filter(postsToFilter));
        }

        @Test
        @DisplayName("date")
        void setFilterAuthorMatt_AND_date() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = Arrays.asList(USER_POST_2);
            FilterAND filterAND = new FilterAND(filterAuthor_Matt,
                    new FilterBetweenDates("2016-01-01T01:01:01Z 2021-01-01T01:01:01Z"));
            Assertions.assertEquals(expectedFitleredList, filterAND.filter(postsToFilter));
        }

        @Test
        @DisplayName("author name: 'funky'")
        void setFilterAuthorMatt_AND_authorFunky() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = Arrays.asList();
            FilterAND filterAND = new FilterAND(filterAuthor_Matt, new FilterAuthor("funky"));
            Assertions.assertEquals(expectedFitleredList, filterAND.filter(postsToFilter));
        }
    }

    @Nested
    @DisplayName("Dates = '2016-01-01T01:01:01Z 2021-01-01T01:01:01Z' AND ....")
    class DatesAND_functionality {

        FilterBetweenDates filterBetweenDates = new FilterBetweenDates("2016-01-01T01:01:01Z 2021-01-01T01:01:01Z");

        @Test
        @DisplayName("content keyword: you")
        void filterBetweenDates_AND_keyword_you() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList(USER_POST_2);
            FilterAND filterAND = new FilterAND(filterBetweenDates, new FilterContentKeyword("you"));
            Assertions.assertEquals(expectedFilteredList, filterAND.filter(postsToFilter));
        }

        @Test
        @DisplayName("liked posts")
        void filterBetweenDates_AND_likedPosts() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = Arrays.asList(USER_POST_1, USER_POST_3);
            FilterAND filterAND = new FilterAND(filterBetweenDates, new FilterLikedPosts());
            Assertions.assertEquals(expectedFitleredList, filterAND.filter(postsToFilter));
        }

        @Test
        @DisplayName("date")
        void filterBetweenDates_AND_betweenDate() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = Arrays.asList();
            FilterAND filterAND = new FilterAND(filterBetweenDates,
                    new FilterBetweenDates("2016-01-01T01:01:01Z 2020-01-01T01:01:01Z"));
            Assertions.assertEquals(expectedFitleredList, filterAND.filter(postsToFilter));
        }

        @Test
        @DisplayName("author name: 'Matt'")
        void filterBetweenDates_AND_authorMatt() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = Arrays.asList(USER_POST_2);
            FilterAND filterAND = new FilterAND(filterBetweenDates, new FilterAuthor("Matt"));
            Assertions.assertEquals(expectedFitleredList, filterAND.filter(postsToFilter));
        }
    }

    @Nested
    @DisplayName("Liked posts AND ...")
    class LikedPostsAND {

        FilterLikedPosts filterLikedPosts = new FilterLikedPosts();

        @Test
        @DisplayName("author name = 'Matt'")
        void filterLikedPosts_AND_authorMatt() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList(USER_POST_3, USER_POST_4);
            FilterAND filterAND = new FilterAND(filterLikedPosts, new FilterAuthor("Steve"));
            Assertions.assertEquals(expectedFilteredList, filterAND.filter(postsToFilter));
        }

        @Test
        @DisplayName("between dates = '2016-01-01T01:01:01Z 2021-01-01T01:01:01Z'")
        void filterLikedPosts_AND_betweenDates() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList(USER_POST_1, USER_POST_3);
            FilterAND filterAND = new FilterAND(filterLikedPosts,
                    new FilterBetweenDates("2016-01-01T01:01:01Z 2021-01-01T01:01:01Z"));
            Assertions.assertEquals(expectedFilteredList, filterAND.filter(postsToFilter));
        }

        @Test
        @DisplayName("content keyword = 'funky'")
        void filterLikedPosts_AND_keywordFunky() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList(USER_POST_6);
            FilterAND filterAND = new FilterAND(filterLikedPosts,
                    new FilterContentKeyword("funky"));
            Assertions.assertEquals(expectedFilteredList, filterAND.filter(postsToFilter));
        }
    }

    @Nested
    @DisplayName("Content keyword = 'li' AND ...")
    class ContentKeywordAND {

        FilterContentKeyword filterContentKeyword = new FilterContentKeyword("li");

        @Test
        @DisplayName("author name = 'Steve'")
        void filterKeywordIs_AND_authorSteve() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList(USER_POST_3);
            FilterAND filterAND = new FilterAND(filterContentKeyword, new FilterAuthor("Steve"));
            Assertions.assertEquals(expectedFilteredList, filterAND.filter(postsToFilter));
        }

        @Test
        @DisplayName("between dates = '2016-01-01T01:01:01Z 2021-01-01T01:01:01Z'")
        void filterKeywordIs_AND_betweenDates() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3);
            FilterAND filterAND = new FilterAND(filterContentKeyword,
                    new FilterBetweenDates("2016-01-01T01:01:01Z 2021-01-01T01:01:01Z"));
            Assertions.assertEquals(expectedFilteredList, filterAND.filter(postsToFilter));
        }

        @Test
        @DisplayName("content keyword = 'funky'")
        void filterKeywordIs_AND_keywordFunky() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList();
            FilterAND filterAND = new FilterAND(filterContentKeyword, new FilterContentKeyword("funky"));
            Assertions.assertEquals(expectedFilteredList, filterAND.filter(postsToFilter));
        }

        @Test
        @DisplayName("liked posts")
        void filterKeywordIs_AND_likedPosts() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList(USER_POST_1, USER_POST_3);
            FilterAND filterAND = new FilterAND(filterContentKeyword, new FilterLikedPosts());
            Assertions.assertEquals(expectedFilteredList, filterAND.filter(postsToFilter));
        }
    }

    @Test
    @DisplayName("Empty input list")
    void setFilterAND_emptyInput() {
        List<UserPost> postsToFilter = Arrays.asList();
        FilterAND filterAND = new FilterAND(new FilterAuthor("Matt"), new FilterContentKeyword("funk"));
        Assertions.assertEquals(Arrays.asList(), filterAND.filter(postsToFilter));
    }

    @Test
    @DisplayName("Null input list")
    void setFilterAND_nullInput() {
        FilterAND filterAND = new FilterAND(new FilterAuthor("Matt"), new FilterContentKeyword("funky"));
        Assertions.assertEquals(null, filterAND.filter(null));
    }

    @Test
    @DisplayName("Null filter")
    void setFilterAND_nullFilter_validInput() {
        FilterAND filterAND = new FilterAND(null, new FilterContentKeyword("funky"));
        Assertions.assertEquals(null, filterAND.filter(null));
    }
}
