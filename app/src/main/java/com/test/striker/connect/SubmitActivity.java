package com.test.striker.connect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SubmitActivity extends AppCompatActivity {
    TextView name;
    TextView email;
    TextView dob;
    TextView address;
    TextView continueApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        dob = (TextView) findViewById(R.id.dob);
        address = (TextView) findViewById(R.id.address);

        String nameString = getIntent().getStringExtra("name");
        String emailString = getIntent().getStringExtra("email");
        String dobString = getIntent().getStringExtra("dob");
        String addressString = getIntent().getStringExtra("address");

        name.setText(nameString);
        email.setText(emailString);
        dob.setText(dobString);
        address.setText(addressString);
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
