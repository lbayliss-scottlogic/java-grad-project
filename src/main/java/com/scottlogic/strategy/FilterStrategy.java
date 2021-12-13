package com.scottlogic.strategy;

import com.scottlogic.UserPost;

import java.util.List;

public interface FilterStrategy {
    List<UserPost> filter(List<UserPost> inputList, String filterCriteria);
}
