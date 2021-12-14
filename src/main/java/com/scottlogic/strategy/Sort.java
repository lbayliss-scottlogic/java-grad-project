package com.scottlogic.strategy;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;

import java.util.List;

public interface Sort {
    List<UserPost> sort(List<UserPost> inputList, SortOrder sortOrder);
}