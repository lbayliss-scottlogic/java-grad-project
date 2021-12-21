package com.scottlogic.filter.combined;

import com.scottlogic.UserPost;
import com.scottlogic.filter.Filter;
import com.scottlogic.filter.FilterAuthor;
import com.scottlogic.filter.FilterBetweenDates;
import com.scottlogic.filter.FilterContentKeyword;
import com.scottlogic.filter.FilterLikedPosts;
import com.scottlogic.filter.combined.FilterOR;
import com.scottlogic.utils.UserPostFilterData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FilterORTest {

    @Nested
    @DisplayName("Author = 'Matt' OR ...")
    class AuthorOR_functionality {

        Filter filterAuthor_Matt = new FilterAuthor("Matt");

        @Test
        @DisplayName("content keyword = 'funky'")
        void filterAuthorMatt_OR_ContentKeywordfunky() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFiltered_authorMatt_OR_keywordfunky();
            FilterOR filterOR = new FilterOR(filterAuthor_Matt, new FilterContentKeyword("funky"));
            Assertions.assertEquals(expectedFilteredList, filterOR.filter(postsToFilter));
        }

        @Test
        @DisplayName("liked posts")
        void filterAuthorMatt_OR_likedPosts() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = UserPostFilterData.getFiltered_authorMatt_OR_likedPosts();
            FilterOR filterOR = new FilterOR(filterAuthor_Matt, new FilterLikedPosts());
            Assertions.assertEquals(expectedFitleredList, filterOR.filter(postsToFilter));
        }

        @Test
        @DisplayName("date")
        void setFilterAuthorMatt_OR_date() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = UserPostFilterData.getFiltered_authorMatt_OR_date();
            FilterOR filterOR = new FilterOR(filterAuthor_Matt,
                    new FilterBetweenDates("2016-01-01T01:01:01Z 2021-01-01T01:01:01Z"));
            Assertions.assertEquals(expectedFitleredList, filterOR.filter(postsToFilter));
        }

        @Test
        @DisplayName("author name: 'funky'")
        void setFilterAuthorMatt_OR_authorFunky() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = UserPostFilterData.getFiltered_authorMatt_OR_authorFunky();
            FilterOR filterOR = new FilterOR(filterAuthor_Matt, new FilterAuthor("funky"));
            Assertions.assertEquals(expectedFitleredList, filterOR.filter(postsToFilter));
        }
    }

    @Nested
    @DisplayName("Dates = '2016-01-01T01:01:01Z 2021-01-01T01:01:01Z' OR ....")
    class DateOR_functionality {

        FilterBetweenDates filterBetweenDates = new FilterBetweenDates("2016-01-01T01:01:01Z 2021-01-01T01:01:01Z");

        @Test
        @DisplayName("author name: 'Mick'")
        void filterBetweenDates_OR_authorNameMick() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredBetweenDates_OR_authorMick();
            FilterOR filterOR = new FilterOR(filterBetweenDates, new FilterAuthor("Mick"));
            Assertions.assertEquals(expectedFilteredList, filterOR.filter(postsToFilter));
        }

        @Test
        @DisplayName("content keyword = 'funky'")
        void filterBetweenDates_OR_ContentKeywordfunky() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredBetweenDates_OR_keywordFunky();
            FilterOR filterOR = new FilterOR(filterBetweenDates, new FilterContentKeyword("funky"));
            Assertions.assertEquals(expectedFilteredList, filterOR.filter(postsToFilter));
        }

        @Test
        @DisplayName("liked posts")
        void filterBetweenDates_OR_likedPosts() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = UserPostFilterData.getFilteredBetweenDates_OR_likedPosts();
            FilterOR filterOR = new FilterOR(filterBetweenDates, new FilterLikedPosts());
            Assertions.assertEquals(expectedFitleredList, filterOR.filter(postsToFilter));
        }

        @Test
        @DisplayName("date")
        void setFilterAuthorMatt_OR_date() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = UserPostFilterData.getFilteredBetweenDates_OR_betweenDates();
            FilterOR filterOR = new FilterOR(filterBetweenDates,
                    new FilterBetweenDates("2000-01-01T01:01:01Z 2005-01-01T01:01:01Z"));
            Assertions.assertEquals(expectedFitleredList, filterOR.filter(postsToFilter));
        }
    }

    @Nested
    @DisplayName("Liked Posts OR ....")
    class LikedPostsOR_functionality {

        FilterLikedPosts filterLikedPosts = new FilterLikedPosts();

        @Test
        @DisplayName("author name = 'Mick'")
        void filterLikedPosts_OR_authorNameMick() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredLikedPosts_OR_authorMick();
            FilterOR filterOR = new FilterOR(filterLikedPosts, new FilterAuthor("Mick"));
            Assertions.assertEquals(expectedFilteredList, filterOR.filter(postsToFilter));
        }

        @Test
        @DisplayName("content keyword = 'funky'")
        void filterLikedPosts_OR_ContentKeywordfunky() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredLikedPosts_OR_keywordFunky();
            FilterOR filterOR = new FilterOR(filterLikedPosts, new FilterContentKeyword("funky"));
            Assertions.assertEquals(expectedFilteredList, filterOR.filter(postsToFilter));
        }

        @Test
        @DisplayName("date")
        void setFilterAuthorMatt_OR_date() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = UserPostFilterData.getFilteredLikedPosts_OR_dateBetween();
            FilterOR filterOR = new FilterOR(filterLikedPosts,
                    new FilterBetweenDates("2000-01-01T01:01:01Z 2005-01-01T01:01:01Z"));
            Assertions.assertEquals(expectedFitleredList, filterOR.filter(postsToFilter));
        }
    }

    @Nested
    @DisplayName("Content keyword = 'you' OR ...")
    class ContentKeywordOR_functionality {

        FilterContentKeyword filterContentKeyword = new FilterContentKeyword("you");

        @Test
        @DisplayName("author name = 'Mick'")
        void filterLikedPosts_OR_authorNameMick() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredKeywordYou_OR_AuthorMick();
            FilterOR filterOR = new FilterOR(filterContentKeyword, new FilterAuthor("Mick"));
            Assertions.assertEquals(expectedFilteredList, filterOR.filter(postsToFilter));
        }

        @Test
        @DisplayName("liked posts")
        void filterLikedPosts_OR_likedPosts() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFilteredList = UserPostFilterData.getFilteredKeywordYou_OR_likedPosts();
            FilterOR filterOR = new FilterOR(filterContentKeyword, new FilterLikedPosts());
            Assertions.assertEquals(expectedFilteredList, filterOR.filter(postsToFilter));
        }

        @Test
        @DisplayName("date")
        void setFilterAuthorMatt_OR_date() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = UserPostFilterData.getFilteredKeywordYou_OR_dates();
            FilterOR filterOR = new FilterOR(filterContentKeyword,
                    new FilterBetweenDates("2000-01-01T01:01:01Z 2005-01-01T01:01:01Z"));
            Assertions.assertEquals(expectedFitleredList, filterOR.filter(postsToFilter));
        }

        @Test
        @DisplayName("content keyword = 'Jeoff'")
        void setFilterKeywordYou_OR_filterKeywordJeoff() {
            List<UserPost> postsToFilter = UserPostFilterData.getUnfilteredData();
            List<UserPost> expectedFitleredList = UserPostFilterData.getFilteredKeywordYou_OR_keywordJeoff();
            FilterOR filterOR = new FilterOR(filterContentKeyword, new FilterContentKeyword("Jeoff"));
            Assertions.assertEquals(expectedFitleredList, filterOR.filter(postsToFilter));
        }
    }

    @Test
    @DisplayName("Empty input list")
    void setFilterOR_emptyInput() {
        List<UserPost> postsToFilter = Arrays.asList();
        FilterOR filterOR = new FilterOR(new FilterAuthor("Matt"), new FilterContentKeyword("funk"));
        Assertions.assertEquals(Arrays.asList(), filterOR.filter(postsToFilter));
    }

    @Test
    @DisplayName("Null input list")
    void setFilterOR_nullInput() {
        FilterOR filterOR = new FilterOR(new FilterAuthor("Matt"), new FilterContentKeyword("funky"));
        Assertions.assertEquals(Arrays.asList(), filterOR.filter(null));
    }
}
