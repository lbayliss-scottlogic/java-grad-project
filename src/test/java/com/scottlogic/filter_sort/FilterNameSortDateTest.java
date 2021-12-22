package com.scottlogic.filter_sort;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;
import com.scottlogic.filter.FilterAuthor;
import com.scottlogic.sort.SortDate;
import com.scottlogic.utils.UserPostFilterSortData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.scottlogic.utils.UserPostFilterSortData.USER_POST_1;
import static com.scottlogic.utils.UserPostFilterSortData.USER_POST_2;
import static com.scottlogic.utils.UserPostFilterSortData.USER_POST_3;
import static com.scottlogic.utils.UserPostFilterSortData.USER_POST_4;
import static com.scottlogic.utils.UserPostFilterSortData.USER_POST_5;
import static com.scottlogic.utils.UserPostFilterSortData.USER_POST_6;

public class FilterNameSortDateTest {

    FilterAuthor filterAuthor = new FilterAuthor("Steve");

    @Nested
    @DisplayName("Author name = 'Steve' and ...")
    class FilterNameSortDate_functionality {

        @Test
        @DisplayName("date ascending")
        void filterAuthorSteve_sortDateAsc() {
            List<UserPost> postsToFilter = UserPostFilterSortData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList(USER_POST_4, USER_POST_6, USER_POST_3);
            FilterNameSortDate filterNameSortDate = new FilterNameSortDate(filterAuthor, new SortDate(SortOrder.ASC));
            Assertions.assertEquals(expectedFilteredList, filterNameSortDate.filter(postsToFilter));
        }

        @Test
        @DisplayName("date descending")
        void filterAuthorSteve_sortDateDesc() {
            List<UserPost> postsToFilter = UserPostFilterSortData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList(USER_POST_3, USER_POST_6, USER_POST_4);
            FilterNameSortDate filterNameSortDate = new FilterNameSortDate(filterAuthor, new SortDate(SortOrder.DESC));
            Assertions.assertEquals(expectedFilteredList, filterNameSortDate.filter(postsToFilter));
        }

        @Test
        @DisplayName("No filter matches")
        void filterNoFilterMatches_sortDateAsc() {
            List<UserPost> postsToFilter = UserPostFilterSortData.getUnfilteredData();
            List<UserPost> expectedFilteredList = Arrays.asList();
            FilterAuthor filterAuthor = new FilterAuthor("Funky bob man");
            FilterNameSortDate filterNameSortDate = new FilterNameSortDate(filterAuthor, new SortDate(SortOrder.ASC));
            Assertions.assertEquals(expectedFilteredList, filterNameSortDate.filter(postsToFilter));
        }
    }

    @Test
    @DisplayName("Empty input list")
    void filterAuthorSteve_sortDateAsc_emptyInput() {
        FilterNameSortDate filterNameSortDate = new FilterNameSortDate(filterAuthor, new SortDate(SortOrder.ASC));
        Assertions.assertEquals(Arrays.asList(), filterNameSortDate.filter(Arrays.asList()));
    }

    @Test
    @DisplayName("Null input list")
    void filterAuthorSteve_sortDateAsc_nullInput() {
        FilterNameSortDate filterNameSortDate = new FilterNameSortDate(filterAuthor, new SortDate(SortOrder.ASC));
        Assertions.assertEquals(null, filterNameSortDate.filter(null));
    }

    @Test
    @DisplayName("Null filter input")
    void filterAuthorSteve_sortDateAsc_nullFilter() {
        List<UserPost> postsToFilter = UserPostFilterSortData.getUnfilteredData();
        FilterNameSortDate filterNameSortDate = new FilterNameSortDate(null, new SortDate(SortOrder.ASC));
        Assertions.assertEquals(null, filterNameSortDate.filter(postsToFilter));
    }
}
