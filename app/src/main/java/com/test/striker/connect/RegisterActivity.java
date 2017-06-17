package com.test.striker.connect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
TextView submit;
    EditText name;
    EditText email;
    EditText dob;
    EditText address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name =(EditText) findViewById(R.id.editText1);
        email = (EditText) findViewById(R.id.editText2);
        dob = (EditText) findViewById(R.id.editText3);
        address = (EditText) findViewById(R.id.editText4);
        submit = (TextView) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this,SubmitActivity.class);
                i.putExtra("name",name.getText().toString());
                i.putExtra("email",email.getText().toString());
                i.putExtra("dob",dob.getText().toString());
                i.putExtra("address",address.getText().toString());
                startActivity(i);
            }
        });
    }
}
