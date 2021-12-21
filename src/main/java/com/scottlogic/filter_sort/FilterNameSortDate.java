package com.scottlogic.filter_sort;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;
import com.scottlogic.filter.Filter;
import com.scottlogic.filter.FilterAuthor;
import com.scottlogic.sort.SortDate;

import java.util.List;

public class FilterNameSortDate implements Filter {

    private FilterAuthor filterAuthor;
    private SortDate sortDate;

    public FilterNameSortDate(FilterAuthor authorFilter, SortDate dateSorter) {
        filterAuthor = authorFilter;
        sortDate = dateSorter;
    }

    @Override
    public List<UserPost> filter(List<UserPost> inputList) {
        if (inputList == null || filterAuthor == null || sortDate == null) {
            return null;
        }
        List<UserPost> outputList = filterAuthor.filter(inputList);
        return sortDate.sort(outputList);
    }
}
