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
import java.util.stream.Collectors;

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

        Map<UserPost, Integer> postKeywordCountMap = getKeywordCount(inputList);

        return sortKeywordCountMap(postKeywordCountMap);
    }

    private Map<UserPost, Integer> getKeywordCount(List<UserPost> inputList) {
        Map<UserPost, Integer> postKeywordCountMap = new HashMap<>();

        for (UserPost userPost : inputList) {
            String content = userPost.getContents();
            Matcher matcher = Pattern.compile(keyword).matcher(content);
            int matchCount = 0;
            while (matcher.find()) {
                matchCount += 1;
            }
            if (matchCount > 0) {
                postKeywordCountMap.put(userPost, matchCount);
            }
        }
        return postKeywordCountMap;
    }

    private List<UserPost> sortKeywordCountMap(Map<UserPost, Integer> inputMap) {

        if (sortOrder.equals(SortOrder.DESC)) {
            return inputMap.entrySet()
                    .stream()
                    .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
        else {
            return inputMap.entrySet()
                    .stream()
                    .sorted(Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }
}
