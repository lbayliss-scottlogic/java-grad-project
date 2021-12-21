package com.scottlogic;

import com.scottlogic.sort.SortContentLength;

import static com.scottlogic.utils.UserPostData.getUserPosts;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<UserPost> userPosts = getUserPosts();
        sortUserPosts(userPosts, SortOrder.ASC);
    }

    /**
     * Prints out user posts in either ascending/descending order (depending on which strategy is called)
     * @param userPosts The list of user posts to print out
     * @param sortOrder direction in which to sort in
     */
    private static void sortUserPosts(List<UserPost> userPosts, SortOrder sortOrder) {
        SortContentLength sortContentLengthAscending = new SortContentLength(SortOrder.ASC);
        sortContentLengthAscending.sort(userPosts);
        System.out.println("Posts ascendingly-sorted with content length Strategy: ");
        for(UserPost userPost : userPosts) {
            System.out.println(userPost + "\n");
        }
    }
}
