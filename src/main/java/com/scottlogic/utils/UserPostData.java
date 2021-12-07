package com.scottlogic.utils;

import com.scottlogic.UserPost;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class UserPostData {
    public static List<UserPost> getUserPosts() {
        UserPost userPost1 = new UserPost("Mick Jagger",
                OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC),
                "You got moves like me?", 2);

        UserPost userPost2 = new UserPost("Matt Damon",
                OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC),
                "How you like them apples?!", 1);

        UserPost userPost3 = new UserPost("Jane Smith",
                OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC),
                "An example of a post \nwith lines breaks.", 3);
        return Arrays.asList(userPost1, userPost2, userPost3);
    }
}
