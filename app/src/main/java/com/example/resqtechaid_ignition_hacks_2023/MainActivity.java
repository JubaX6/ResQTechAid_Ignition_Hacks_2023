package com.example.resqtechaid_ignition_hacks_2023;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.resqtechaid_ignition_hacks_2023.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ImageView bgapp, cloverimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bgapp = (ImageView) findViewById(R.id.bgapp);
        cloverimg = (ImageView) findViewById(R.id.cloverimg);

        replaceFragment(new HomeFragment());






        binding.bottomNavigationView.setOnItemReselectedListener(item -> {

            int id = item.getItemId();

            if(id == R.id.home) {
                replaceFragment(new HomeFragment());

            } else if(id == R.id.settings) {
                replaceFragment(new SettingsFragment());
            } else{
                // Calling 911
                String phoneNumber = "5148349680";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }

        });
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}