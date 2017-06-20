package com.test.striker.connect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SubmitActivity extends AppCompatActivity {
    TextView name;
    TextView email;
    TextView dob;
    TextView address;
    TextView continueApp;
    TextView phone;
    TextView phoneType;

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

        String nameString = "Name : " + getIntent().getStringExtra("name");
        String emailString = "Email : " + getIntent().getStringExtra("email");
        String dobString = "DOB : " + getIntent().getStringExtra("dob");
        String addressString = "Address : " + getIntent().getStringExtra("address");
        String phoneString = "Phone : " + getIntent().getStringExtra("phone");
        String phone_type = getIntent().getStringExtra("phone_type");

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
                Intent intent = new Intent();
                intent.setClassName("com.android.calculator2","com.android.calculator2.Calculator");
                startActivity(intent);            }
        });
    }
}
