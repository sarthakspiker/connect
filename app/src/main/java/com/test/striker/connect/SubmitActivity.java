package com.test.striker.connect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

import static com.test.striker.connect.R.id.profile;

public class SubmitActivity extends AppCompatActivity {
    TextView name;
    TextView email;
    TextView dob;
    TextView address;
    TextView continueApp;
    TextView phone;
    TextView phoneType;
    ImageView imageView;
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
        imageView = (ImageView) findViewById(profile);

        final String nameString = "Name : " + getIntent().getStringExtra("name");
        final String emailString = "Email : " + getIntent().getStringExtra("email");
        final String dobString = "DOB : " + getIntent().getStringExtra("dob");
        final String addressString = "Address : " + getIntent().getStringExtra("address");
        final String phoneString = "Phone : " + getIntent().getStringExtra("phone");
        final String phone_type = getIntent().getStringExtra("phone_type");
        Bitmap bitmap = getIntent().getParcelableExtra("picture");
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
                Bundle bundle = new Bundle();
                bundle.putString("name", nameString);
                bundle.putString("email", emailString);
                bundle.putString("dob", dobString);
                bundle.putString("address", addressString);
                bundle.putString("phone", phoneString);
                bundle.putString("phone_type", phone_type);
                ByteArrayOutputStream bs = new ByteArrayOutputStream();
                Bitmap bitmap1 = getIntent().getParcelableExtra("picture");
                if (bitmap1 == null) {
                    bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.blank_profile);
                }
                bitmap1.compress(Bitmap.CompressFormat.PNG, 50, bs);
                byte[] byteArray = bs.toByteArray();
                bundle.putByteArray("picture", byteArray);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}