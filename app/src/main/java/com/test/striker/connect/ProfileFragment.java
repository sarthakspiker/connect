package com.test.striker.connect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;
import static com.test.striker.connect.R.id.profile;
import static com.test.striker.connect.RegisterActivity.REQUEST_IMAGE_CAPTURE;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    TextView name;
    TextView email;
    TextView dob;
    TextView address;
    TextView phone;
    TextView phoneType;
    ImageView imageView;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
            roundedBitmapDrawable.setCornerRadius(150.0f);
            roundedBitmapDrawable.setAntiAlias(true);
            imageView.setImageDrawable(roundedBitmapDrawable);
        }
    }

    private void dispatchTakePictureIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
        return rootView;
    }
}