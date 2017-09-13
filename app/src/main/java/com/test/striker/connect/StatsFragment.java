package com.test.striker.connect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.striker.connect.helper.DatabaseHelper;

import java.util.ArrayList;

import static java.sql.Types.NULL;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatsFragment extends Fragment {
    DatabaseHelper db;

    public StatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        db = new DatabaseHelper(getContext());
        ArrayList<Post> posts = db.getPopular();
        Post currentPost = posts.get(0);
        TextView nameTextView = (TextView) view.findViewById(R.id.name_text);
        nameTextView.setText(currentPost.getName());

        TextView timeTextView = (TextView) view.findViewById(R.id.time_text);
        timeTextView.setText(currentPost.getTime());

        TextView statusTextView = (TextView) view.findViewById(R.id.status_text);
        statusTextView.setText(currentPost.getPost());

        TextView likesTextView = (TextView) view.findViewById(R.id.number_likes);
        likesTextView.setText(String.valueOf(currentPost.getLikes()));

        TextView commentsTextView = (TextView) view.findViewById(R.id.number_comments);
        commentsTextView.setText(String.valueOf(currentPost.getComments()));

        ImageView uploadedImageView = (ImageView) view.findViewById(R.id.uploaded_image);
        if (currentPost.getImgId() == NULL) {
            uploadedImageView.setVisibility(View.GONE);
        } else {
            uploadedImageView.setImageResource(currentPost.getImgId());
        }
        return view;
    }

}
