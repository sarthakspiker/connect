package com.test.striker.connect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static com.test.striker.connect.R.id.profile;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView name;
        TextView email;
        TextView dob;
        TextView address;
        TextView phone;
        TextView phoneType;
        ImageView imageView;

        Bundle bundle = getActivity().getIntent().getExtras();
        String nameString = bundle.getString("name");
        String emailString = bundle.getString("email");
        String dobString = bundle.getString("dob");
        String addressString = bundle.getString("address");
        String phoneString = bundle.getString("phone");
        String phone_type = bundle.getString("phone_type");
        Bitmap bitmap = BitmapFactory.decodeByteArray(bundle.getByteArray("picture"), 0, bundle.getByteArray("picture").length);
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        name = (TextView) rootView.findViewById(R.id.name);
        email = (TextView) rootView.findViewById(R.id.email);
        dob = (TextView) rootView.findViewById(R.id.dob);
        address = (TextView) rootView.findViewById(R.id.address);
        phone = (TextView) rootView.findViewById(R.id.phoneText);
        phoneType = (TextView) rootView.findViewById(R.id.phoneType);
        imageView = (ImageView) rootView.findViewById(profile);
        if (bitmap != null) {
            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
            roundedBitmapDrawable.setCornerRadius(150.0f);
            roundedBitmapDrawable.setAntiAlias(true);
            imageView.setImageDrawable(roundedBitmapDrawable);
        }
        name.setText(nameString);
        email.setText(emailString);
        dob.setText(dobString);
        address.setText(addressString);
        phone.setText(phoneString);
        phoneType.setText(phone_type);

        return rootView;
    }
}