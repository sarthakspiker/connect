package com.test.striker.connect;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.striker.connect.helper.DatabaseHelper;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {

    DatabaseHelper db;
    ContactAdapter contactAdapter;
    TextView textView;
    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
        textView = (TextView) rootView.findViewById(R.id.noContact);
        db = new DatabaseHelper(getContext());
        final ArrayList<Contact> contacts = db.getAllContacts();
        final ArrayList<ContactJoin> joins = db.getJoin();

        db.closeDB();
        //Check for empty list
        if (contacts.isEmpty()) {
            textView.setVisibility(View.VISIBLE);
        }

        contactAdapter = new ContactAdapter(getActivity(), contacts);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(contactAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Contact contact = contacts.get(i);
                //String name = contact.getName();
                //String status = contact.getStatus();

                ContactJoin join = joins.get(i);
                String name = join.getName();
                String status = join.getStatus();
                String email = join.getmEmail();
                String phone = join.getmPhone();
                String address = join.getmAddress();

                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("\nName : " + name + "\nEmail : " + name + "@gmail.com\nStatus : " + status + "\nPhone : 9734324367\nAddress : India\n")
                        .setCancelable(true);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();*/

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("\nName : " + name + "\nEmail : " + email + "\nStatus : " + status + "\nPhone : " + phone + "\nAddress : " + address + "\n")
                        .setCancelable(true);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final Contact contact = contacts.get(i);
                String name = contact.getName();
                builder.setMessage("Are you sure you want to delete " + name + " from contacts?")
                        .setCancelable(true)
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                db = new DatabaseHelper(getContext());
                                db.deleteContact(contact.getmID());
                                Toast.makeText(getContext(), "Contact Deleted", Toast.LENGTH_SHORT).show();
                                contactAdapter.remove(contact);
                                contactAdapter.notifyDataSetChanged();
                                if (contacts.isEmpty()) {
                                    textView.setVisibility(View.VISIBLE);
                                }
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return true;
            }
        });
        return rootView;
    }

}