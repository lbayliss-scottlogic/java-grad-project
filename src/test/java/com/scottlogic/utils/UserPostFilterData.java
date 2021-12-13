package com.scottlogic.utils;

import com.scottlogic.UserPost;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class UserPostFilterData {
    private static UserPost userPost1 = new UserPost("Mick Jagger",
            OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC),
            "You got moves like me?", 2);

    private static UserPost userPost2 = new UserPost("Matt Damon",
            OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC),
            "How you like them apples?!", 1);

    private static UserPost userPost3 = new UserPost("Steve Madden",
            OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC),
            "An example of a post \nwith lines breaks.", 3);

    private static UserPost userPost4 = new UserPost("Steve",
            OffsetDateTime.of(1997, 11, 14, 10, 50, 1, 0, ZoneOffset.UTC),
            "My name is Jeoff", 9);

    private static UserPost userPost5 = new UserPost("This funky-name",
            OffsetDateTime.of(2001, 1, 1, 1, 1, 1, 1, ZoneOffset.UTC),
            "funky funk funk", 10);
    private static UserPost userPost6 = new UserPost("steve madden",
            OffsetDateTime.of(2001, 1, 1, 1, 1, 1, 2, ZoneOffset.UTC),
            "funky funky funky", 11);

    public static List<UserPost> getUnfilteredData () { return Arrays.asList(userPost1, userPost2, userPost3, userPost4, userPost5, userPost6); }

    public static List<UserPost> getFilteredAuthor_Steve() { return Arrays.asList(userPost3, userPost4); }

    public static List<UserPost> getFilteredAuthor_steve() { return Arrays.asList(userPost6); }
}