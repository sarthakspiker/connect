package com.test.striker.connect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.striker.connect.helper.DatabaseHelper;

import java.util.ArrayList;

public class SubmitActivity extends AppCompatActivity {
    TextView name;
    TextView email;
    TextView dob;
    TextView address;
    TextView continueApp;
    TextView phone;
    TextView phoneType;
    ImageView imageView;
    DatabaseHelper db;
    ArrayList<Profile> profile;
    PictureHandler pictureHandler = new PictureHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        dob = (TextView) findViewById(R.id.dob);
        address = (TextView) findViewById(R.id.address);
        phone = (TextView) findViewById(R.id.phoneText);
        phoneType = (TextView) findViewById(R.id.phoneType);
        imageView = (ImageView) findViewById(R.id.profile);

        db = new DatabaseHelper(getApplicationContext());
        profile = db.getAllProfile();
        Profile mProfile = profile.get(0);

        final String nameString = "Name : " + mProfile.getName();
        final String emailString = "Email : " + mProfile.getEmail();
        final String dobString = "DOB : " + mProfile.getDob();
        final String addressString = "Address : " + mProfile.getAddress();
        final String phoneString = "Phone : " + mProfile.getPhone();
        final String phone_type = mProfile.getPhoneType();

        Bitmap bitmap = pictureHandler.loadImageFromStorage(getApplicationContext());
        if (bitmap != null) {
            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
            roundedBitmapDrawable.setCornerRadius(150.0f);
            roundedBitmapDrawable.setAntiAlias(true);
            imageView.setImageDrawable(roundedBitmapDrawable);
        }
        name.setText(nameString);
        email.setText(emailString);
        dob.setText(dobString);
        address.setText(addressString);
        phone.setText(phoneString);
        phoneType.setText(phone_type);
        continueApp = (TextView) findViewById(R.id.openup);
        continueApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubmitActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}