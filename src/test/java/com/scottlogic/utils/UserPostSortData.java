package com.scottlogic.utils;

import com.scottlogic.UserPost;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class UserPostSortData {

    private final static UserPost USER_POST_1 = new UserPost("Mick Jagger",
            OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC),
            "You got moves like me?", 2);

    private final static UserPost USER_POST_2 = new UserPost("Matt Damon",
            OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC),
            "How you like them apples?!", 1);

    private final static UserPost USER_POST_3 = new UserPost("Jane Austin Smith",
            OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC),
            "An example of a post \nwith lines breaks.", 3);

    private final static UserPost USER_POST_4 = new UserPost("Steve",
            OffsetDateTime.of(1997, 11, 14, 10, 50, 1, 0, ZoneOffset.UTC),
            "My name is Jeoff", 9);

    private final static UserPost USER_POST_5 = new UserPost("This funky-name",
            OffsetDateTime.of(2001, 1, 1, 1, 1, 1, 1, ZoneOffset.UTC),
            "funky funk funk", 10);

    public static List<UserPost> getUnsortedList() { return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3, USER_POST_4, USER_POST_5); }

    public static List<UserPost> getSortedAuthorAscendingList() { return Arrays.asList(USER_POST_3, USER_POST_2, USER_POST_1, USER_POST_4, USER_POST_5); }

    public static List<UserPost> getSortedAuthorDescendingList() { return Arrays.asList(USER_POST_5, USER_POST_4, USER_POST_1, USER_POST_2, USER_POST_3); }

    public static List<UserPost> getSortedDateAscendingList() { return Arrays.asList(USER_POST_4, USER_POST_5, USER_POST_1, USER_POST_2, USER_POST_3); }

    public static List<UserPost> getSortedDateDescendingList() { return Arrays.asList(USER_POST_3, USER_POST_2, USER_POST_1, USER_POST_5, USER_POST_4); }

    public static List<UserPost> getSortedLikesAscendingList() { return Arrays.asList(USER_POST_2, USER_POST_1, USER_POST_3, USER_POST_4, USER_POST_5); }

    public static List<UserPost> getSortedLikesDescendingList() { return Arrays.asList(USER_POST_5, USER_POST_4, USER_POST_3, USER_POST_1, USER_POST_2); }

    public static List<UserPost> getSortedContentLengthAscending() { return Arrays.asList(USER_POST_5, USER_POST_4, USER_POST_1, USER_POST_2, USER_POST_3); }

    public static List<UserPost> getSortedContentLengthDescending() { return Arrays.asList(USER_POST_3, USER_POST_2, USER_POST_1, USER_POST_4, USER_POST_5); }

    public static List<UserPost> getSortedAuthorSurnameAscending() { return Arrays.asList(USER_POST_4, USER_POST_2, USER_POST_5, USER_POST_1, USER_POST_3); }

    public static List<UserPost> getSortedAuthorSurnameDescending() { return Arrays.asList(USER_POST_3, USER_POST_1, USER_POST_5, USER_POST_2, USER_POST_4); }

}
