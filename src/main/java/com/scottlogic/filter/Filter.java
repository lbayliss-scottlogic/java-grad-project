package com.scottlogic.filter;

import com.scottlogic.UserPost;

import java.util.List;

public interface Filter {
    List<UserPost> filter(List<UserPost> inputList);
}
