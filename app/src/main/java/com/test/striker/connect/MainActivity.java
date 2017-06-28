package com.test.striker.connect;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String UID = "emailKey";
    public static final String Password = "passKey";
    public ArrayList<String> arrayList;
    TextView textView;
    TextView login;
    TextView register;
    int n = 3;
    AutoCompleteTextView autoCompleteTextView;
    EditText nameText, passwordText;
    String name, uid, password;
    SharedPreferences sharedPreferences;

    public void Save() {
        String n = nameText.getText().toString();
        String p = passwordText.getText().toString();
        String e = autoCompleteTextView.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Name, n);
        editor.putString(UID, e);
        editor.putString(Password, p);

        editor.apply();
    }

    public void Get() {
        sharedPreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Name)) {
            nameText.setText(sharedPreferences.getString(Name, ""));
        }
        if (sharedPreferences.contains(UID)) {
            autoCompleteTextView.setText(sharedPreferences.getString(UID, ""));
        }
        if (sharedPreferences.contains(Password)) {
            passwordText.setText(sharedPreferences.getString(Password, ""));
        }
    }
    public void register(){
        Intent i = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure you want to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("Alert!");
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface helvetica = Typeface.createFromAsset(getAssets(),"Helvetica Light.ttf");

        textView = (TextView) findViewById(R.id.textView);
        textView.setTypeface(helvetica);
        register = (TextView) findViewById(R.id.register);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.uid);
        nameText = (EditText) findViewById(R.id.editText1);
        passwordText = (EditText) findViewById(R.id.password);

        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        Get();
        arrayList = new ArrayList<>();
        arrayList.add("sarthak");
        arrayList.add("Sarthak");
        arrayList.add("Sarthak ");
        arrayList.add("prakhar");
        arrayList.add("kishore");
        arrayList.add("yogendra");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.select_dialog_item, arrayList);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(3);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
        login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uid = autoCompleteTextView.getText().toString();
                name = nameText.getText().toString();
                password = passwordText.getText().toString();
                Save();
                if (/*(arrayList.contains(uid) || arrayList.contains(name)) && arrayList.contains(password)*/ true) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", "Name : Sarthak Kumar");
                    bundle.putString("email", "Email : spikerstriker@gmail.com");
                    bundle.putString("dob", "DOB : 19121997");
                    bundle.putString("address", "Address : India");
                    bundle.putString("phone", "Phone : 9962029154");
                    bundle.putString("phone_type", "Home");
                    intent.putExtras(bundle);
                startActivity(intent);            }
                else {
                    n--;
                    Toast.makeText(MainActivity.this, "Wrong Credentials :" + n + " trial left", Toast.LENGTH_SHORT).show();
                    if (n<=0){
                        register();
                    n=3;
                    }
                }
            }
        });
    }
}