package com.scottlogic.utils;

import com.scottlogic.UserPost;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class UserPostFilterSortData {
    private static UserPost userPost1 = new UserPost("Mick Jagger",
            OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC),
            "you got moves like me?", 2);

    private static UserPost userPost2 = new UserPost("Matt Damon",
            OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC),
            "How you like them apples you funky man!", 0);

    private static UserPost userPost3 = new UserPost("Steve Madden",
            OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC),
            "you are the method of all evil.", 3);

    private static UserPost userPost4 = new UserPost("Steve",
            OffsetDateTime.of(1997, 11, 14, 10, 50, 1, 0, ZoneOffset.UTC),
            "My name is Jeoff", 9);

    private static UserPost userPost5 = new UserPost("This funky-name",
            OffsetDateTime.of(2001, 1, 1, 1, 1, 1, 0, ZoneOffset.UTC),
            "funky funky funky", 0);

    private static UserPost userPost6 = new UserPost("Steve Jones",
            OffsetDateTime.of(2001, 1, 1, 1, 1, 1, 0, ZoneOffset.UTC),
            "Funky funky funky", 11);

    public static List<UserPost> getUnfilteredData () {
        return Arrays.asList(userPost1, userPost2, userPost3, userPost4, userPost5, userPost6);
    }

    public static List<UserPost> getFilteredNameSteve_sortedDateAsc() {
        return Arrays.asList(userPost4, userPost6, userPost3);
    }

    public static List<UserPost> getFilteredNameSteve_sortedDateDesc() {
        return Arrays.asList(userPost3, userPost6, userPost4);
    }

    public static List<UserPost> getFilteredKeywordFunky_sortFrequencyAsc() {
        return Arrays.asList(userPost2, userPost6, userPost5);
    }

    public static List<UserPost> filterKeywordYou_sortFrequencyAsc_sameCount() {
        return Arrays.asList(userPost1, userPost3, userPost2);
    }

    public static List<UserPost> filterKeywordChess_sortFrequencyAsc_zeroCount() {
        return Arrays.asList();
    }
}
