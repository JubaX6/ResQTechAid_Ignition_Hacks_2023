package com.example.resqtechaid_ignition_hacks_2023;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Switch nightModeSwitch, notificationsSwitch;
    private static final String SHARED_PREFS_NAME = "MyPrefs";
    private static final String SWITCH_STATE_KEY = "switchState";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        nightModeSwitch = rootView.findViewById(R.id.switchNightMode);
        notificationsSwitch = rootView.findViewById(R.id.switchNotifications);

        notificationsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Switch is turned on, enable notifications
                Toast.makeText(requireActivity(), "Enabling Notifications", Toast.LENGTH_SHORT).show();
                enableNotifications();
            } else {
                // Switch is turned off, disable notifications
                Toast.makeText(requireActivity(), "Disabling Notifications", Toast.LENGTH_SHORT).show();
                disableNotifications();
            }
        });

        sharedPreferences = requireActivity().getSharedPreferences(SHARED_PREFS_NAME, getContext().MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Restore switch state from shared preferences
        boolean isSwitchChecked = sharedPreferences.getBoolean(SWITCH_STATE_KEY, false);
        nightModeSwitch.setChecked(isSwitchChecked);

        nightModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Update shared preferences with new switch state
            editor.putBoolean(SWITCH_STATE_KEY, isChecked);
            editor.apply();

            if (isChecked) {
                // Switch is turned on (Light mode)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                // Switch is turned off (Dark mode)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

            // Update the fragment's view to reflect the new theme
            updateFragmentTheme(isChecked);
        });

        return rootView;
    }

    private void updateFragmentTheme(boolean isLightMode) {
        if (isLightMode) {
            // Update views for light mode
            nightModeSwitch.setText("Light Mode");
            // Update other views as needed
        } else {
            // Update views for dark mode
            nightModeSwitch.setText("Dark Mode");
            // Update other views as needed
        }
    }

    // Enable notifications
    private void enableNotifications() {
        // Use NotificationManager to create and manage notifications
        NotificationManager notificationManager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);

        // Create a notification channel if necessary (for Android 8.0 and above)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "your_channel_id",
                    "Your Channel Name",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("Your Channel Description");
            notificationManager.createNotificationChannel(channel);
        }

        // You can create and send notifications here
        // Example:
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "your_channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Notification Title")
                .setContentText("Notification Text")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Show the notification
        int notificationId = 1;
        notificationManager.notify(notificationId, builder.build());
    }

    // Disable notifications
    private void disableNotifications() {
        // Use NotificationManager to cancel notifications
        int notificationId = 1;
        NotificationManager notificationManager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(notificationId);
    }
}