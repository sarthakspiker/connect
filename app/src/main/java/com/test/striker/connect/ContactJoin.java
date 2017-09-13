package com.test.striker.connect;

/**
 * Created by sarthak on 6/9/17.
 */

public class ContactJoin {

    private String mName;
    private String mEmail;
    private String mStatus;
    private String mPhone;
    private String mAddress;
    private int mID;

    public ContactJoin() {
    }

    public ContactJoin(String mName, String mEmail, String mStatus, String mPhone, String mAddress, int mID) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mStatus = mStatus;
        this.mPhone = mPhone;
        this.mAddress = mAddress;
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

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }
}
