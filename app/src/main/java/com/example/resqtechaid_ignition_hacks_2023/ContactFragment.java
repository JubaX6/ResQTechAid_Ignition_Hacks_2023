package com.example.resqtechaid_ignition_hacks_2023;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageButton imgAxel, imgJuba, imgMo, imgShawn;
    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

        imgAxel = rootView.findViewById(R.id.imageButtonAxel);
        imgJuba = rootView.findViewById(R.id.imageButtonJuba);
        imgMo = rootView.findViewById(R.id.imageButtonMo);
        imgShawn = rootView.findViewById(R.id.imageButtonShawn);


        imgAxel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String linkedInUrl = "https://www.linkedin.com/in/axel-moran-caballero-9324ab263/";  // Replace with the correct LinkedIn profile URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl));
                startActivity(intent); }
        });

        imgJuba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String linkedInUrl = "https://www.linkedin.com/in/juba-laiche/";  // Replace with the correct LinkedIn profile URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl));
                startActivity(intent);}
        });

        imgShawn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String linkedInUrl = "https://www.linkedin.com/in/shanvin/";  // Replace with the correct LinkedIn profile URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl));
                startActivity(intent);
            }
        });

        imgMo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String linkedInUrl = "https://www.linkedin.com/in/mohamed-sanoko-96445a272/";  // Replace with the correct LinkedIn profile URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl));
                startActivity(intent);
            }
        });

        return rootView;
    }

}
