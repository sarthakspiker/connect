package com.test.striker.connect;

/**
 * Created by sarthak on 27/6/17.
 */

public class Contact {

    private String mName;
    private String mStatus;
    private int mID;

    public Contact() {
    }

    public Contact(String mName, String mStatus, int mID) {
        this.mName = mName;
        this.mStatus = mStatus;
        this.mID = mID;
    }


    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getName() {
        return mName;
    }

    public String getStatus() {
        return mStatus;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }
}