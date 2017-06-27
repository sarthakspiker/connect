package com.test.striker.connect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {


    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);

        final ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Sunny Singh", "Busy"));
        contacts.add(new Contact("Saurav raj", "Call if urgent"));
        contacts.add(new Contact("Lucky Chadda", "Paris is awesome!"));
        contacts.add(new Contact("Supreet Lohani", "Gym Time"));
        contacts.add(new Contact("Chaubey ji", "Happy Holidays"));
        contacts.add(new Contact("Shusant Rajput", "Shooting at Delhi"));
        contacts.add(new Contact("Sunny Singh", "Busy"));
        contacts.add(new Contact("Saurav raj", "Call if urgent"));
        contacts.add(new Contact("Lucky Chadda", "Paris is awesome!"));
        contacts.add(new Contact("Supreet Lohani", "Gym Time"));
        contacts.add(new Contact("Chaubey ji", "Happy Holidays"));
        contacts.add(new Contact("Shusant Rajput", "Shooting at Delhi"));

        ContactAdapter contactAdapter = new ContactAdapter(getActivity(), contacts);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(contactAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact contact = contacts.get(i);
                String name = contact.getName();
                String status = contact.getStatus();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("\nName : " + name + "\nEmail : " + name + "@gmail.com\nStatus : " + status + "\nPhone : 9734324367\nAddress : India\n")
                        .setCancelable(true);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return rootView;
    }

}