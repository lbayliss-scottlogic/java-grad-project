package com.scottlogic;

import com.scottlogic.sort.SortAuthorAscending;
import com.scottlogic.sort.SortAuthorDescending;

import com.scottlogic.sort.SortDateAscending;

import static com.scottlogic.utils.UserPostData.getUserPosts;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<UserPost> userPosts = getUserPosts();
        //sortAuthorAscending(userPosts);
        //sortAuthorDescending(userPosts);
        sortDateAscending(userPosts);
    }

    /**
     * Prints out user posts in Author-ascending order
     * @param userPosts The list of user posts to print out
     */
    private static void sortAuthorAscending(List<UserPost> userPosts) {
        SortContext sortAuthorAscending = new SortContext(new SortAuthorAscending());
        sortAuthorAscending.sortPosts(userPosts);
        System.out.println("Posts ascendingly-sorted with Strategy: ");
        for(UserPost userPost : userPosts) {
            System.out.println(userPost + "\n");
        }
    }

    /**
     * Prints out user posts in Author-descending order
     * @param userPosts The list of user posts to sort then print out
     */
    private static void sortAuthorDescending(List<UserPost> userPosts) {
        SortContext sortAuthorDescending = new SortContext(new SortAuthorDescending());
        sortAuthorDescending.sortPosts(userPosts);
        System.out.println("Posts descendingly-sorted with Strategy: ");
        for(UserPost userPost : userPosts) {
            System.out.println(userPost + "\n");
        }
    }

    private static void sortDateAscending(List<UserPost> userPosts) {
        SortContext sortDateAscending = new SortContext(new SortDateAscending());
        sortDateAscending.sortPosts(userPosts);
        System.out.println("Posts ascendingly-sorted by date: ");
        for(UserPost userPost : userPosts) {
            System.out.println(userPost + "\n");
        }
    }


}
