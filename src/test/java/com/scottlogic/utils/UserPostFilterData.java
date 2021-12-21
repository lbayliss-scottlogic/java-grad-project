package com.scottlogic.utils;

import com.scottlogic.UserPost;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class UserPostFilterData {
    private final static UserPost USER_POST_1 = new UserPost("Mick Jagger",
            OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC),
            "You got moves like me?", 2);

    private final static UserPost USER_POST_2 = new UserPost("Matt Damon",
            OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC),
            "How you like them apples?1", 0);

    private final static UserPost USER_POST_3 = new UserPost("Steve Madden",
            OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC),
            "An example of a post \nwith lines breaks.", 3);

    private final static UserPost USER_POST_4 = new UserPost("Steve",
            OffsetDateTime.of(1997, 11, 14, 10, 50, 1, 0, ZoneOffset.UTC),
            "My name is Jeoff", 9);

    private final static UserPost USER_POST_5 = new UserPost("This funky-name",
            OffsetDateTime.of(2001, 1, 1, 1, 1, 1, 0, ZoneOffset.UTC),
            "funky funk funk", 0);

    private final static UserPost USER_POST_6 = new UserPost("steve madden",
            OffsetDateTime.of(2001, 1, 1, 1, 1, 1, 0, ZoneOffset.UTC),
            "Funky Funky funky", 11);

    public static List<UserPost> getUnfilteredData () {
        return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3, USER_POST_4, USER_POST_5, USER_POST_6); }

    public static List<UserPost> getFilteredAuthor_Steve() { return Arrays.asList(USER_POST_3, USER_POST_4); }

    public static List<UserPost> getFilteredAuthor_steve() { return Arrays.asList(USER_POST_6); }

    public static List<UserPost> getFilteredDateEquals() { return Arrays.asList(USER_POST_5, USER_POST_6); }

    public static List<UserPost> getFilteredDateBetween() { return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3); }

    public static List<UserPost> getFilteredDateBetween_reversedInput() {
        return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3); }

    public static List<UserPost> getFilteredDateBetween_equalsStartDate() {
        return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3); }

    public static List<UserPost> getFilteredDateBetween_equalsEndDate() {
        return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3); }

    public static List<UserPost> getFilteredContentKeyword_you() { return Arrays.asList(USER_POST_2); }

    public static List<UserPost> getFilteredContentKeyword_You() { return Arrays.asList(USER_POST_1); }

    public static List<UserPost> getFilteredContentKeyword_yuo() { return Arrays.asList(); }

    public static List<UserPost> getFilteredContentKeyword_Funky_funky() { return Arrays.asList(USER_POST_6); }

    public static List<UserPost> getFilteredContentKeyword_number_1() { return Arrays.asList(USER_POST_2); }

    public static List<UserPost> getFilteredContentKeyword_special_character() { return Arrays.asList(USER_POST_1, USER_POST_2); }

    public static List<UserPost> getFilteredLikedPosts() {
        return Arrays.asList(USER_POST_1, USER_POST_3, USER_POST_4, USER_POST_6); }

    public static List<UserPost> getFiltered_authorMatt_OR_keywordfunky() {
        return Arrays.asList(USER_POST_2, USER_POST_5, USER_POST_6);
    }

    public static List<UserPost> getFiltered_authorMatt_OR_likedPosts() {
        return Arrays.asList(USER_POST_2, USER_POST_1, USER_POST_3, USER_POST_4, USER_POST_6);
    }

    public static List<UserPost> getFiltered_authorMatt_OR_date() {
        return Arrays.asList(USER_POST_2, USER_POST_1, USER_POST_3);
    }

    public static List<UserPost> getFiltered_authorMatt_OR_authorFunky() {
        return Arrays.asList(USER_POST_2, USER_POST_5);
    }

    public static List<UserPost> getFilteredBetweenDates_OR_authorMick() {
        return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3);
    }

    public static List<UserPost> getFilteredBetweenDates_OR_keywordFunky() {
        return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3, USER_POST_5, USER_POST_6);
    }

    public static List<UserPost> getFilteredBetweenDates_OR_likedPosts() {
        return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3, USER_POST_4, USER_POST_6);
    }

    public static List<UserPost> getFilteredBetweenDates_OR_betweenDates() {
        return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3, USER_POST_5, USER_POST_6);
    }

    public static List<UserPost> getFilteredLikedPosts_OR_authorMick() {
        return Arrays.asList(USER_POST_1, USER_POST_3, USER_POST_4, USER_POST_6);
    }

    public static List<UserPost> getFilteredLikedPosts_OR_keywordFunky() {
        return Arrays.asList(USER_POST_1, USER_POST_3, USER_POST_4, USER_POST_6, USER_POST_5);
    }

    public static List<UserPost> getFilteredLikedPosts_OR_dateBetween() {
        return Arrays.asList(USER_POST_1, USER_POST_3, USER_POST_4, USER_POST_6, USER_POST_5);
    }

    public static List<UserPost> getFilteredKeywordYou_OR_AuthorMick() {
        return Arrays.asList(USER_POST_2, USER_POST_1);
    }

    public static List<UserPost> getFilteredKeywordYou_OR_likedPosts() {
        return Arrays.asList(USER_POST_2, USER_POST_1, USER_POST_3, USER_POST_4, USER_POST_6);
    }

    public static List<UserPost> getFilteredKeywordYou_OR_dates() {
        return Arrays.asList(USER_POST_2, USER_POST_5, USER_POST_6);
    }

    public static List<UserPost> getFilteredKeywordYou_OR_keywordJeoff() {
        return Arrays.asList(USER_POST_2, USER_POST_4);
    }

    public static List<UserPost> getFiltered_authorMatt_AND_keyword_you() {
        return Arrays.asList(USER_POST_2);
    }

    public static List<UserPost> getFiltered_authorMatt_AND_likedPosts() {
        return Arrays.asList();
    }

    public static List<UserPost> getFiltered_authorMatt_AND_date() {
        return Arrays.asList(USER_POST_2);
    }

    public static List<UserPost> getFiltered_authorMatt_AND_authorFunky() {
        return Arrays.asList();
    }

    public static List<UserPost> getFilteredBetweenDates_AND_keywordYou() {
        return Arrays.asList(USER_POST_2);
    }

    public static List<UserPost> getFilteredBetweenDates_AND_likedPosts() {
        return Arrays.asList(USER_POST_1, USER_POST_3);
    }

    public static List<UserPost> getFilteredBetweenDates_AND_betweenDates() {
        return Arrays.asList();
    }

    public static List<UserPost> getFilteredBetweenDates_AND_authorFunky() {
        return Arrays.asList();
    }

    public static List<UserPost> getFilteredLikedPosts_AND_authorSteve() {
        return Arrays.asList(USER_POST_3, USER_POST_4);
    }

    public static List<UserPost> getFilteredLikedPosts_AND_betweenDates() {
        return Arrays.asList(USER_POST_1, USER_POST_3);
    }

    public static List<UserPost> getFilteredLikedPosts_AND_keywordFunky() { return Arrays.asList(USER_POST_6); }

    public static List<UserPost> getFilteredKeywordLi_AND_authorSteve() {
        return Arrays.asList(USER_POST_3);
    }

    public static List<UserPost> getFilteredKeywordLi_AND_betweenDates() {
        return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3);
    }

    public static List<UserPost> getFilteredKeywordLi_AND_keywordFunky() {
        return Arrays.asList();
    }

    public static List<UserPost> getFilteredKeywordLi_AND_likedPosts() {
        return Arrays.asList(USER_POST_1, USER_POST_3);
    }
}
