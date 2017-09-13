package com.test.striker.connect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.striker.connect.helper.DatabaseHelper;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
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
    DatabaseHelper db;
    ArrayList<Profile> profile;
    PictureHandler pictureHandler = new PictureHandler();

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            //RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
            //roundedBitmapDrawable.setCornerRadius(150.0f);
            //roundedBitmapDrawable.setAntiAlias(true);
            //imageView.setImageDrawable(roundedBitmapDrawable);
            imageView.setImageBitmap(bitmap);
            pictureHandler.saveToInternalStorage(bitmap, getContext());
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

        db = new DatabaseHelper(getContext());

        profile = db.getAllProfile();
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        if (!profile.isEmpty()) {
            Profile mProfile = profile.get(0);

            final String nameString = "Name : " + mProfile.getName();
            final String emailString = "Email : " + mProfile.getEmail();
            final String dobString = "DOB : " + mProfile.getDob();
            final String addressString = "Address : " + mProfile.getAddress();
            final String phoneString = "Phone : " + mProfile.getPhone();
            final String phone_type = mProfile.getPhoneType();

            name = (TextView) rootView.findViewById(R.id.name);
            email = (TextView) rootView.findViewById(R.id.email);
            dob = (TextView) rootView.findViewById(R.id.dob);
            address = (TextView) rootView.findViewById(R.id.address);
            phone = (TextView) rootView.findViewById(R.id.phoneText);
            phoneType = (TextView) rootView.findViewById(R.id.phoneType);
            imageView = (ImageView) rootView.findViewById(R.id.profile);
            Bitmap bitmap = pictureHandler.loadImageFromStorage(getContext());
            if (bitmap != null) {
                //RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                //roundedBitmapDrawable.setCornerRadius(150.0f);
                //roundedBitmapDrawable.setAntiAlias(true);
                //imageView.setImageDrawable(roundedBitmapDrawable);
                imageView.setImageBitmap(bitmap);
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
        }
        return rootView;
    }
}