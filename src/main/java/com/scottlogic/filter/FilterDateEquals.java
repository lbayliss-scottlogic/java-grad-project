package com.scottlogic.filter;

import com.scottlogic.UserPost;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterDateEquals implements Filter {

    private String filterCriteria;

    public FilterDateEquals(String filterBy) {
        filterCriteria = filterBy;
    }

    @Override
    public List<UserPost> filter(List<UserPost> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return Arrays.asList();
        }
        List<UserPost> outputList = new ArrayList<>(inputList);
        OffsetDateTime dateTime = OffsetDateTime.parse(filterCriteria);
        outputList.removeIf(a -> !a.getDateTime().equals(dateTime));
        return outputList;
    }
}
