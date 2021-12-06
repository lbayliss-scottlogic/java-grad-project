package com.scottlogic;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserPost userPost1 = new UserPost("Joe Bloggs",
                OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC),
                "Hello World!", 2);

        UserPost userPost2 = new UserPost("Matt Damon",
                OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC),
                "Another example post.", 1);

        UserPost userPost3 = new UserPost("Jane Smith",
                OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC),
                "An example of a post \nwith lines breaks.", 3);

        List<UserPost> userPosts = Arrays.asList(userPost1, userPost2, userPost3);
        printAllUserPosts(userPosts);
        printUserPostsByAuthor(userPosts);
    }

    /**
     * Prints out all user posts
     * @param userPosts The list of user posts to print out
     */
    private static void printAllUserPosts(List<UserPost> userPosts) {
        for(UserPost userPost : userPosts) {
            System.out.println(userPost);
            System.out.println("");
        }
    }

    /**
     * Prints out all user posts sorted by author ascending
     * @param userPosts The list of user posts to sort then print out
     */
    private static void printUserPostsByAuthor(List<UserPost> userPosts) {
        AuthorPostSorter authorPostSorter = new AuthorPostSorter();
        List<UserPost> sortedPostsByAuthor = authorPostSorter.sort(userPosts);
        System.out.println("Sorted List: ");
        for(UserPost userPost : sortedPostsByAuthor) {
            System.out.println(userPost);
            System.out.println("");
        }
    }
}
