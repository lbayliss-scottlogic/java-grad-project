package com.scottlogic;

import static com.scottlogic.utils.UserPostData.getUserPosts;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<UserPost> userPosts = getUserPosts();
        printAllUserPosts(userPosts);
        printUserPostsByAscendingAuthor(userPosts);
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
    private static void printUserPostsByAscendingAuthor(List<UserPost> userPosts) {
        AuthorPostSorter authorPostSorter = new AuthorPostSorter();
        List<UserPost> sortedPostsByAuthor = authorPostSorter.sort(userPosts, SortOrder.ASC);
        System.out.println("Sorted List: ");
        for(UserPost userPost : sortedPostsByAuthor) {
            System.out.println(userPost);
            System.out.println("");
        }
    }
}
