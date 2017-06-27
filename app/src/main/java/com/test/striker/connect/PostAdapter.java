package com.test.striker.connect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.sql.Types.NULL;


/**
 * Created by sarthak on 25/6/17.
 */

public class PostAdapter extends ArrayAdapter<Post> {
    String s;
    public PostAdapter(Context context, ArrayList<Post> post) {
        super(context, 0, post);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.wall_item, parent, false);
        }
        Post currentPost = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text);
        nameTextView.setText(currentPost.getmName());

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text);
        timeTextView.setText(currentPost.getmTime());

        TextView statusTextView = (TextView) listItemView.findViewById(R.id.status_text);
        statusTextView.setText(currentPost.getmStatus());

        ImageView uploadedImageView = (ImageView) listItemView.findViewById(R.id.uploaded_image);
        if (currentPost.getmImgId() == NULL) {
            uploadedImageView.setVisibility(View.GONE);
        } else {
            uploadedImageView.setImageResource(currentPost.getmImgId());
        }


        Button button = (Button) listItemView.findViewById(R.id.comment_button);
        final EditText editText = (EditText) listItemView.findViewById(R.id.editText);
        final TextView textView = (TextView) listItemView.findViewById(R.id.comment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = editText.getText().toString();
                if (s.length() > 0) {
                    textView.setText(s);
                    editText.setText("");
                }
            }
        });
        return listItemView;
    }
}
