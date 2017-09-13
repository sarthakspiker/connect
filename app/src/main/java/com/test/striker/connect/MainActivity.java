package com.test.striker.connect;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.striker.connect.helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.Random;

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

    void SetupDatabase() {
        //Dummy Data
        final Random random = new Random();
        String s = "hi this is a test string to check paragraph layout"
                + "This line simply creates a new line and checks the integrity of the layout if the data feed is a large string";
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        db.createPost(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, 3, 4, R.drawable.attractions));
        db.createPost(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, 5, 9, R.drawable.chennai));
        db.createPost(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, 14, 24, R.drawable.hotel));
        db.createPost(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, 13, 19, R.drawable.restaurant));
        db.createPost(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, 6, 9, R.drawable.shopping));
        db.createPost(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, 10, 11, R.drawable.chennai));
        db.createPost(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, 12, 17, R.drawable.attractions));

        db.createContact(new Contact("Shusant Rajput", "Shooting at Delhi", 1));
        db.createContact(new Contact("Sunny Singh", "Busy", 2));
        db.createContact(new Contact("Saurav raj", "Call if urgent", 3));
        db.createContact(new Contact("Lucky Chadda", "Paris is awesome!", 4));
        db.createContact(new Contact("Supreet Lohani", "Gym Time", 5));
        db.createContact(new Contact("Chaubey ji", "Happy Holidays", 6));

        //db.createContact(new Contact("Shusant Rajput", "Shooting at Delhi",6));
        //db.createContact(new Contact("Sunny Singh", "Busy",7));
        //db.createContact(new Contact("Saurav raj", "Call if urgent",8));
        //db.createContact(new Contact("Lucky Chadda", "Paris is awesome!",9));
        //db.createContact(new Contact("Supreet Lohani", "Gym Time",10));
        //db.createContact(new Contact("Chaubey ji", "Happy Holidays",11));
        //db.createContact(new Contact("Shusant Rajput", "Shooting at Delhi",12));


        db.createProfile(new Profile("Sarthak Kumar", 0, "admin", "spikerstriker@gmail.com", "09/12/1997", "7338956654", "home", 0, "Potheri, Chennai"));
        db.createProfile(new Profile("Shusant Rajput", 1, "admin", "ShusantRajput@gmail.com", "04/12/1987", "7767857567", "office", 1, "Tnagar, Chennai"));
        db.createProfile(new Profile("Sunny Singh", 2, "admin", "SunnySingh@gmail.com", "03/11/1994", "7338651135", "home", 2, "Velachery, Chennai"));
        db.createProfile(new Profile("Saurav raj", 3, "admin", "Sauravraj@gmail.com", "12/04/1967", "7336767854", "office", 3, "Nungambakkam, Chennai"));
        db.createProfile(new Profile("Lucky Chadda", 4, "admin", "LuckyChadda@gmail.com", "01/02/1993", "733554654", "home", 4, "Egmore, Chennai"));
        db.createProfile(new Profile("Supreet Lohani", 5, "admin", "SupreetLohani@gmail.com", "09/10/1998", "7338541654", "Mambalam", 5, "Potheri, Chennai"));
        db.createProfile(new Profile("Chaubey ji", 6, "admin", "Chaubeyji@gmail.com", "09/12/1984", "7338526654", "home", 6, "Tambaramadmin, Chennai"));

    }
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

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            // <---- run your one time code here
            SetupDatabase();
            // mark first time has runned.
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        }
        arrayList = new ArrayList<>();
        arrayList.add("admin");
        arrayList.add("Admin");
        arrayList.add("admin ");
        arrayList.add("Admin ");

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
                if ((arrayList.contains(uid) || arrayList.contains(name)) && arrayList.contains(password)) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
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