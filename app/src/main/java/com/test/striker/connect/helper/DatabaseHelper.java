package com.test.striker.connect.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.test.striker.connect.Contact;
import com.test.striker.connect.ContactJoin;
import com.test.striker.connect.Post;
import com.test.striker.connect.Profile;

import java.util.ArrayList;

/**
 * Created by sarthak on 17/8/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String DATABASE_NAME = "ConnectPlus";

    // Table Names
    private static final String TABLE_CONTACT = "contacts";
    private static final String TABLE_POST = "posts";
    private static final String TABLE_Profile = "profile";

    // Common column names
    private static final String KEY_NAME = "name";
    private static final String KEY_ID = "id";

    // Contacts column names
    private static final String KEY_STATUS = "status";

    // Posts column names
    private static final String KEY_TIME = "time";
    private static final String KEY_POST = "post";
    private static final String KEY_IMG_ID = "img_id";
    private static final String KEY_LIKES = "likes";
    private static final String KEY_COMMENTS = "comments";

    // Profile column names
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_DOB = "dob";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_PHONE_TYPE = "phone_type";
    private static final String KEY_PROFILE_PIC = "profile_pic";
    private static final String KEY_ADDRESS = "address";

    // Table Create Statements
    // Contacts table create statement
    private static final String CREATE_TABLE_CONTACT = "CREATE TABLE "
            + TABLE_CONTACT + "(" + KEY_NAME + " TEXT," + KEY_STATUS
            + " TEXT," + KEY_ID + " INTEGER" + ")";

    // Posts table create statement
    private static final String CREATE_TABLE_POST = "CREATE TABLE "
            + TABLE_POST + "(" + KEY_NAME + " TEXT," + KEY_TIME + " TEXT,"
            + KEY_POST + " TEXT," + KEY_IMG_ID + " INTEGER,"
            + KEY_LIKES + " INTEGER," + KEY_COMMENTS + " INTEGER" + ")";

    // Profiles table create statement
    private static final String CREATE_TABLE_PROFILE = "CREATE TABLE "
            + TABLE_Profile + "(" + KEY_NAME + " TEXT," + KEY_ID + " INTEGER,"
            + KEY_PASSWORD + " TEXT," + KEY_EMAIL + " TEXT,"
            + KEY_DOB + " TEXT," + KEY_PHONE + " TEXT,"
            + KEY_PHONE_TYPE + " TEXT," + KEY_PROFILE_PIC + " INTEGER,"
            + KEY_ADDRESS + " TEXT " + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_CONTACT);
        db.execSQL(CREATE_TABLE_POST);
        db.execSQL(CREATE_TABLE_PROFILE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Profile);
        onCreate(db);

    }

    public void createContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_STATUS, contact.getStatus());
        values.put(KEY_ID, contact.getmID());
        // insert row
        db.insert(TABLE_CONTACT, null, values);
    }

    public void createPost(Post post) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, post.getName());
        values.put(KEY_TIME, post.getTime());
        values.put(KEY_POST, post.getPost());
        values.put(KEY_IMG_ID, post.getImgId());
        values.put(KEY_LIKES, post.getLikes());
        values.put(KEY_COMMENTS, post.getComments());
        // insert row
        db.insert(TABLE_POST, null, values);
    }

    public void createProfile(Profile profile) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, profile.getName());
        values.put(KEY_ID, profile.getID());
        values.put(KEY_PASSWORD, profile.getPassword());
        values.put(KEY_EMAIL, profile.getEmail());
        values.put(KEY_DOB, profile.getDob());
        values.put(KEY_PHONE, profile.getPhone());
        values.put(KEY_PHONE_TYPE, profile.getPhoneType());
        values.put(KEY_PROFILE_PIC, profile.getImgId());
        values.put(KEY_ADDRESS, profile.getAddress());

        // insert row
        db.insert(TABLE_Profile, null, values);
    }

    /*
 * getting all contacts
 * */
    public ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACT;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Contact td = new Contact();
                td.setmName(c.getString((c.getColumnIndex(KEY_NAME))));
                td.setmStatus((c.getString(c.getColumnIndex(KEY_STATUS))));
                td.setmID((c.getInt(c.getColumnIndex(KEY_ID))));
                // adding to todo list
                contacts.add(td);
            } while (c.moveToNext());
        }
        return contacts;
    }

    /*
* getting all posts
* */
    public ArrayList<Post> getAllPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_POST;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Post td = new Post();
                td.setName(c.getString((c.getColumnIndex(KEY_NAME))));
                td.setTime((c.getString(c.getColumnIndex(KEY_TIME))));
                td.setPost((c.getString(c.getColumnIndex(KEY_POST))));
                td.setImgId((c.getInt(c.getColumnIndex(KEY_IMG_ID))));
                td.setLikes((c.getInt(c.getColumnIndex(KEY_LIKES))));
                td.setComments((c.getInt(c.getColumnIndex(KEY_COMMENTS))));
                // adding to list
                posts.add(td);
            } while (c.moveToNext());
        }
        return posts;
    }

    /*
* getting all posts
* */
    public ArrayList<Profile> getAllProfile() {
        ArrayList<Profile> profiles = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_Profile;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Profile td = new Profile();
                td.setName(c.getString((c.getColumnIndex(KEY_NAME))));
                td.setID((c.getInt(c.getColumnIndex(KEY_ID))));
                td.setPassword((c.getString(c.getColumnIndex(KEY_PASSWORD))));
                td.setEmail((c.getString(c.getColumnIndex(KEY_EMAIL))));
                td.setDob((c.getString(c.getColumnIndex(KEY_DOB))));
                td.setPhone((c.getString(c.getColumnIndex(KEY_PHONE))));
                td.setPhoneType((c.getString(c.getColumnIndex(KEY_PHONE_TYPE))));
                td.setImgId((c.getInt(c.getColumnIndex(KEY_PROFILE_PIC))));
                td.setAddress((c.getString(c.getColumnIndex(KEY_ADDRESS))));
                // adding to todo list
                profiles.add(td);
            } while (c.moveToNext());
        }
        return profiles;
    }

    /*
     * Deleting a todo
     */
    public void deleteContact(int contact_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACT, KEY_ID + " = ?",
                new String[]{String.valueOf(contact_id)});
    }

    public void deleteProfile(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Profile, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    public ArrayList<ContactJoin> getJoin() {
        ArrayList<ContactJoin> contactJoins = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_CONTACT + " a INNER JOIN " + TABLE_Profile
                + " b ON a." + KEY_ID + "= b." + KEY_ID;

        // select * from table1 a inner join table2 b on a.id=b.other_id

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                ContactJoin td = new ContactJoin();
                td.setmName(c.getString((c.getColumnIndex(KEY_NAME))));
                td.setmEmail((c.getString(c.getColumnIndex(KEY_EMAIL))));
                td.setmStatus((c.getString(c.getColumnIndex(KEY_STATUS))));
                td.setmPhone((c.getString(c.getColumnIndex(KEY_PHONE))));
                td.setmAddress((c.getString(c.getColumnIndex(KEY_ADDRESS))));
                td.setmID((c.getInt(c.getColumnIndex(KEY_ID))));
                // adding to todo list
                contactJoins.add(td);
            } while (c.moveToNext());
        }
        return contactJoins;
    }

    //getting most popular
    public ArrayList<Post> getPopular() {
        ArrayList<Post> posts = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_POST + " WHERE " + KEY_LIKES + " + " + KEY_COMMENTS + " = (SELECT MAX( " + KEY_LIKES + " + " + KEY_COMMENTS + " ) FROM " + TABLE_POST + " )";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Post td = new Post();
                td.setName(c.getString((c.getColumnIndex(KEY_NAME))));
                td.setTime((c.getString(c.getColumnIndex(KEY_TIME))));
                td.setPost((c.getString(c.getColumnIndex(KEY_POST))));
                td.setImgId((c.getInt(c.getColumnIndex(KEY_IMG_ID))));
                td.setLikes((c.getInt(c.getColumnIndex(KEY_LIKES))));
                td.setComments((c.getInt(c.getColumnIndex(KEY_COMMENTS))));
                // adding to list
                posts.add(td);
            } while (c.moveToNext());
        }
        return posts;
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}