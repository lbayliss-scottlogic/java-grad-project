package com.scottlogic;

import com.scottlogic.sort.SortAuthor;
import com.scottlogic.sort.SortDate;
import com.scottlogic.sort.SortContentLength;
import com.scottlogic.sort.SortAuthorSurname;
import com.scottlogic.sort.SortLikes;

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
     */
    private static void sortUserPosts(List<UserPost> userPosts, SortOrder sortOrder) {
        SortContext sortContentLengthAscending = new SortContext(new SortContentLength());
        sortContentLengthAscending.sortPosts(userPosts, SortOrder.ASC);
        System.out.println("Posts ascendingly-sorted with content length Strategy: ");
        for(UserPost userPost : userPosts) {
            System.out.println(userPost + "\n");
        }
    }
}
