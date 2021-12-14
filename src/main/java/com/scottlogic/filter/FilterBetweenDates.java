package com.scottlogic.filter;

import com.scottlogic.UserPost;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterBetweenDates implements Filter {
    @Override
    public List<UserPost> filter(List<UserPost> inputList, String filterCriteria) {
        if (inputList == null || inputList.isEmpty()) {
            return Arrays.asList();
        }

        String[] dateRange = filterCriteria.split(" ");
        List<UserPost> outputList = new ArrayList<>(inputList);
        OffsetDateTime dateRangeStart = OffsetDateTime.parse(dateRange[0]);
        OffsetDateTime dateRangeEnd = OffsetDateTime.parse(dateRange[1]);

        if (dateRangeStart.isAfter(dateRangeEnd)) {
            outputList.removeIf(a -> !isDateWithinRange(a.getDateTime(), dateRangeEnd, dateRangeStart));
        }
        else {
            outputList.removeIf(a -> !isDateWithinRange(a.getDateTime(), dateRangeStart, dateRangeEnd));
        }
        return outputList;
    }

    private boolean isDateWithinRange(OffsetDateTime testDate, OffsetDateTime startDate, OffsetDateTime endDate) {
        return !(testDate.isBefore(startDate) || testDate.isAfter(endDate));
    }
}
