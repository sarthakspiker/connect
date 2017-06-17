package com.test.striker.connect;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
TextView textView;
    TextView login;
    TextView register;
    int n = 3;
    public ArrayList<String> arrayList;
    AutoCompleteTextView autoCompleteTextView;
    String s;
    public void register(){
        Intent i = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(i);
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
                s = autoCompleteTextView.getText().toString();
                arrayList = new ArrayList<String>();
                arrayList.add("sarthak");
                arrayList.add("Sarthak");
                arrayList.add("Sarthak ");
                arrayList.add("prakhar");
                arrayList.add("kishore");
                arrayList.add("yogendra");
                if (arrayList.contains(s)){
                Intent intent = new Intent();
                intent.setClassName("com.android.calculator2","com.android.calculator2.Calculator");
                startActivity(intent);            }
                else {
                    n--;
                    Toast.makeText(MainActivity.this,"Wrong Crudentials :"+ n +" trial left",Toast.LENGTH_SHORT).show();
                    if (n<=0){
                        register();
                    n=3;
                    }
                }
            }
        });
    }
}
