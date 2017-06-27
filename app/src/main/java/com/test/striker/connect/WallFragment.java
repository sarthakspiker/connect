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

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class WallFragment extends Fragment {

    TextView textView;
    EditText editText;
    Button button;
    Button postButton;

    public WallFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wall_list, container, false);
        String s = "hi this is a test string to check paragraph layout"
                + "This line simply creates a new line and checks the integrity of the layout if the data feed is a large string";
        final Random random = new Random();
        final ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, R.drawable.attractions));
        posts.add(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, R.drawable.chennai));
        posts.add(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, R.drawable.hotel));
        posts.add(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, R.drawable.restaurant));
        posts.add(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, R.drawable.shopping));
        posts.add(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, R.drawable.chennai));
        posts.add(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), s, R.drawable.attractions));
        final PostAdapter adapter = new PostAdapter(getActivity(), posts);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
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
                    adapter.insert(new Post("Sarthak", random.nextInt(12) + ":" + (random.nextInt(50) + 10), post), 0);
                }
            }
        });
        listView.setAdapter(adapter);
        return rootView;
    }

}
