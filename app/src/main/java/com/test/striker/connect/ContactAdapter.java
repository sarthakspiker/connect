package com.test.striker.connect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sarthak on 27/6/17.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(@NonNull Context context, ArrayList<Contact> contacts) {

        super(context, 0, contacts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.contact_item, parent, false);
        }
        Contact currentContact = getItem(position);
        TextView nameText = (TextView) listView.findViewById(R.id.name_text);
        nameText.setText(currentContact.getName());
        TextView statusText = (TextView) listView.findViewById(R.id.status_text);
        statusText.setText(currentContact.getStatus());
        return listView;
    }
}