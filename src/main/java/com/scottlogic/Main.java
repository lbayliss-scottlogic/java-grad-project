package com.scottlogic;

import com.scottlogic.sort.*;

import static com.scottlogic.utils.UserPostData.getUserPosts;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<UserPost> userPosts = getUserPosts();
        sortAscending(userPosts);
        sortDescending(userPosts);
    }

    /**
     * Prints out user posts in ascending order of
     * @param userPosts The list of user posts to print out
     */
    private static void sortAscending(List<UserPost> userPosts) {
        SortContext sortContentLengthAscending = new SortContext(new SortContentLength());
        sortContentLengthAscending.sortPosts(userPosts, SortOrder.ASC);
        System.out.println("Posts ascendingly-sorted with Strategy: ");
        for(UserPost userPost : userPosts) {
            System.out.println(userPost + "\n");
        }
    }

    /**
     * Prints out user posts in descending order of
     * @param userPosts The list of user posts to sort then print out
     */
    private static void sortDescending(List<UserPost> userPosts) {
        SortContext sortContentLengthDescending = new SortContext(new SortContentLength());
        sortContentLengthDescending.sortPosts(userPosts, SortOrder.DESC);
        System.out.println("Posts descendingly-sorted with Strategy: ");
        for(UserPost userPost : userPosts) {
            System.out.println(userPost + "\n");
        }
    }
}
