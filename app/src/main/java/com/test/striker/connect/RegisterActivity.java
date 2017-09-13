package com.test.striker.connect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.test.striker.connect.helper.DatabaseHelper;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    DatabaseHelper db;
    TextView submit;
    EditText name;
    EditText email;
    EditText dob;
    EditText address;
    EditText phone;
    Spinner spinner;
    ArrayList<String> arrayList;
    String phoneType = "Home";
    ImageView profile;
    RoundedBitmapDrawable roundedBitmapDrawable;
    Bitmap bitmap;
    PictureHandler pictureHandler = new PictureHandler();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            bitmap = (Bitmap) extras.get("data");
            roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
            roundedBitmapDrawable.setCornerRadius(150.0f);
            roundedBitmapDrawable.setAntiAlias(true);
            profile.setImageDrawable(roundedBitmapDrawable);
            pictureHandler.saveToInternalStorage(bitmap, getApplicationContext());
        }
    }

    private void dispatchTakePictureIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        phoneType = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name =(EditText) findViewById(R.id.editText1);
        email = (EditText) findViewById(R.id.editText2);
        dob = (EditText) findViewById(R.id.editText3);
        address = (EditText) findViewById(R.id.editText4);
        submit = (TextView) findViewById(R.id.submit);
        phone = (EditText) findViewById(R.id.phoneText);
        spinner = (Spinner) findViewById(R.id.spinner);
        profile = (ImageView) findViewById(R.id.profile);
        spinner.setOnItemSelectedListener(this);
        db = new DatabaseHelper(getApplicationContext());
        arrayList = new ArrayList<>();
        arrayList.add("Home");
        arrayList.add("Office");
        arrayList.add("Other");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayList);
        spinner.setAdapter(adapter);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().trim().equals("")) {
                    name.setError("Name is required!");
                } else if (email.getText().toString().trim().equals("")) {
                    email.setError("Email is required!");
                } else if (dob.getText().toString().trim().equals("")) {
                    dob.setError("DOB is required!");
                } else if (address.getText().toString().trim().equals("")) {
                    address.setError("Address is required!");
                } else if (phone.getText().toString().trim().equals("")) {
                    phone.setError("Phone number is required!");
                } else {

                    final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
                    progressDialog.setMessage("Logging you in..");
                    progressDialog.show();

//        After 2 Seconds i dismiss progress Dialog
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            try {
                                Thread.sleep(1000);
                                if (progressDialog.isShowing())
                                    progressDialog.dismiss();
                                db.deleteProfile(1);
                                db.createProfile(new Profile(name.getText().toString(), 1, name.getText().toString(), email.getText().toString(), dob.getText().toString(), phone.getText().toString()
                                        , phoneType, 1, address.getText().toString()));
                                Intent i = new Intent(RegisterActivity.this, SubmitActivity.class);
                                startActivity(i);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                }
            }
        });
    }
}