package com.scottlogic.context;

import com.scottlogic.UserPost;
import com.scottlogic.strategy.FilterStrategy;

import java.util.List;

public class FilterContext {
    public FilterStrategy filterStrategy;

    public FilterContext(FilterStrategy filterStrategy) { this.filterStrategy = filterStrategy; }

    public List<UserPost> filterPosts(List<UserPost> inputList, String filterCriteria) {
        return filterStrategy.filter(inputList, filterCriteria);
    }
}
