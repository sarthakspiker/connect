package com.test.striker.connect;

import static java.sql.Types.NULL;

/**
 * Created by sarthak on 25/6/17.
 */

public class Post {
    private String mName;
    private String mTime;
    private String mPost;
    private int mImgId = NULL;
    private int mLikes = 0;
    private int mComments = 0;

    //Constructors
    public Post(String mName, String mTime, String mPost, int mLikes, int mComments, int mImgId) {
        this.mName = mName;
        this.mTime = mTime;
        this.mPost = mPost;
        this.mImgId = mImgId;
        this.mLikes = mLikes;
        this.mComments = mComments;
    }

    public Post(String mName, String mTime, String mPost, int mLikes, int mComments) {

        this.mName = mName;
        this.mTime = mTime;
        this.mPost = mPost;
        this.mLikes = mLikes;
        this.mComments = mComments;
    }

    public Post() {
    }

    //Getters
    public String getName() {
        return mName;
    }

    //Setters
    public void setName(String mName) {
        this.mName = mName;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }

    public String getPost() {
        return mPost;
    }

    public void setPost(String mPost) {
        this.mPost = mPost;
    }

    public int getImgId() {
        return mImgId;
    }

    public void setImgId(int mImgId) {
        this.mImgId = mImgId;
    }

    public int getComments() {
        return mComments;
    }

    public void setComments(int mComments) {
        this.mComments = mComments;
    }

    public int getLikes() {
        return mLikes;
    }

    public void setLikes(int mLikes) {
        this.mLikes = mLikes;
    }
}
