package com.test.striker.connect;

/**
 * Created by sarthak on 27/6/17.
 */

public class Contact {
    private String mName;
    private String mStatus;

    public Contact(String mName, String mStatus) {
        this.mName = mName;
        this.mStatus = mStatus;
    }

    public String getName() {
        return mName;
    }

    public String getStatus() {
        return mStatus;
    }
}