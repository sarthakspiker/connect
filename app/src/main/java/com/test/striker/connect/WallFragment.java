package com.test.striker.connect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.test.striker.connect.helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class WallFragment extends Fragment {

    TextView textView;
    EditText editText;
    Button button;
    Button postButton;
    DatabaseHelper db;
    ArrayList<Post> posts;
    public WallFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wall_list, container, false);
        final Random random = new Random();
        db = new DatabaseHelper(getContext());
        posts = db.getAllPosts();
        Collections.reverse(posts);
        db.closeDB();
        final PostAdapter adapter = new PostAdapter(getActivity(), posts);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.new_post_layout, listView, false);
        listView.addHeaderView(header, null, false);
        final EditText editText = (EditText) header.findViewById(R.id.editText);
        postButton = (Button) header.findViewById(R.id.post_button);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.getText().toString().equals("")) {
                    String post = editText.getText().toString();
                    editText.setText("");
                    postButton.animate();
                    db = new DatabaseHelper(getContext());
                    db.createPost(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), post, 0, 0));
                    db.closeDB();
                    adapter.insert(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), post, 0, 0), 0);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        listView.setAdapter(adapter);
        return rootView;
    }

}