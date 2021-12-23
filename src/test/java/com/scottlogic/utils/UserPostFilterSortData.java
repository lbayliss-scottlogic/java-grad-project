package com.scottlogic.utils;

import com.scottlogic.UserPost;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class UserPostFilterSortData {
    public final static UserPost USER_POST_1 = new UserPost("Mick Jagger",
            OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC),
            "you got moves like me?", 2);

    public final static UserPost USER_POST_2 = new UserPost("Matt Damon",
            OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC),
            "How you like them apples you funky man!", 0);

    public final static UserPost USER_POST_3 = new UserPost("Steve Madden",
            OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC),
            "you are the method of all evil.", 3);

    public final static UserPost USER_POST_4 = new UserPost("Steve",
            OffsetDateTime.of(1997, 11, 14, 10, 50, 1, 0, ZoneOffset.UTC),
            "My name is Jeoff", 9);

    public final static UserPost USER_POST_5 = new UserPost("This funky-name",
            OffsetDateTime.of(2001, 1, 1, 1, 1, 1, 0, ZoneOffset.UTC),
            "funky funky funky", 0);

    public final static UserPost USER_POST_6 = new UserPost("Steve Jones",
            OffsetDateTime.of(2001, 1, 1, 1, 1, 1, 0, ZoneOffset.UTC),
            "Funky funky funky", 11);

    public static List<UserPost> getUnfilteredData () {
        return Arrays.asList(USER_POST_1, USER_POST_2, USER_POST_3, USER_POST_4, USER_POST_5, USER_POST_6);
    }
}
