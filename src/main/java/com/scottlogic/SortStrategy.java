package com.scottlogic;

import java.util.List;

public interface SortStrategy {
    List<UserPost> sort(List<UserPost> inputList, SortOrder sortOrder);
}