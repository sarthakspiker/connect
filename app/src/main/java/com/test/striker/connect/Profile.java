package com.test.striker.connect;

/**
 * Created by sarthak on 30/8/17.
 */

public class Profile {

    private String mName;
    private int mID;
    private String mPassword;
    private String mEmail;
    private String mDob;
    private String mPhone;
    private String mPhoneType;
    private int mImgId;
    private String mAddress;

    public Profile(String mName, int mID, String mPassword, String mEmail, String mDob, String mPhone, String mPhoneType, int mImgId, String mAddress) {
        this.mName = mName;
        this.mID = mID;
        this.mPassword = mPassword;
        this.mEmail = mEmail;
        this.mDob = mDob;
        this.mPhone = mPhone;
        this.mPhoneType = mPhoneType;
        this.mImgId = mImgId;
        this.mAddress = mAddress;
    }

    public Profile() {
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getDob() {
        return mDob;
    }

    public void setDob(String mDob) {
        this.mDob = mDob;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getPhoneType() {
        return mPhoneType;
    }

    public void setPhoneType(String mPhoneType) {
        this.mPhoneType = mPhoneType;
    }

    public int getImgId() {
        return mImgId;
    }

    public void setImgId(int mImgId) {
        this.mImgId = mImgId;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

}