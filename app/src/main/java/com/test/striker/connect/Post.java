package com.test.striker.connect;

import static java.sql.Types.NULL;

/**
 * Created by sarthak on 25/6/17.
 */

public class Post {
    private int mProfile = NULL;
    private String mName;
    private String mTime;
    private String mStatus;
    private int mImgId = NULL;

    public Post(String mName, String mTime, String mStatus) {
        this.mName = mName;
        this.mTime = mTime;
        this.mStatus = mStatus;
    }

    public Post(String mName, String mTime, String mStatus, int mImgId) {

        this.mName = mName;
        this.mTime = mTime;
        this.mStatus = mStatus;
        this.mImgId = mImgId;
    }

    public Post(int mProfile, String mName, String mTime, String mStatus, int mImgId) {

        this.mProfile = mProfile;
        this.mName = mName;
        this.mTime = mTime;
        this.mStatus = mStatus;
        this.mImgId = mImgId;
    }


    public int getmProfile() {
        return mProfile;
    }

    public String getmName() {
        return mName;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmStatus() {
        return mStatus;
    }

    public int getmImgId() {
        return mImgId;
    }

}
