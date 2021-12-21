package com.scottlogic.filter_sort;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;
import com.scottlogic.filter.Filter;
import com.scottlogic.filter.FilterContentKeyword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterKeywordSortFrequency implements Filter {

    private String keyword;
    private SortOrder sortOrder;

    public FilterKeywordSortFrequency(String filterWord, SortOrder orderToSort) {
        keyword = filterWord;
        sortOrder = orderToSort;
    }

    @Override
    public List<UserPost> filter(List<UserPost> inputList) {
        if (inputList == null || keyword == null || sortOrder == null) {
            return null;
        }

        Map<UserPost, Integer> filteredList = new HashMap<>();

        for (UserPost userPost : inputList) {
            String content = userPost.getContents();
            Matcher matcher = Pattern.compile(keyword).matcher(content);
            int matchCount = 0;
            while (matcher.find()) {
                matchCount += 1;
            }
            if (matchCount > 0) {
                filteredList.put(userPost, matchCount);
            }
        }

        LinkedHashMap<UserPost, Integer> sortedList = new LinkedHashMap<>();

        if (sortOrder.equals(SortOrder.DESC)) {
            filteredList.entrySet()
                    .stream()
                    .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(a -> sortedList.put(a.getKey(), a.getValue()));
        }
        else {
            filteredList.entrySet()
                    .stream()
                    .sorted(Entry.comparingByValue())
                    .forEachOrdered(a -> sortedList.put(a.getKey(), a.getValue()));
        }

        return new ArrayList<>(sortedList.keySet());
    }
}
