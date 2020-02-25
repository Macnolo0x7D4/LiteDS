/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.liteds.ui.home;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import me.macnolo.libds.enums.Protocol;
import me.macnolo.liteds.R;
import me.macnolo.liteds.UIThread;
import me.macnolo.liteds.ui.ClassesRunnables;

import static android.content.Context.BATTERY_SERVICE;

public class HomeFragment extends Fragment {

    public Handler handler = new Handler();
    public Handler settings = new Handler();

    private Button disableButton;
    private Button enableButton;
    private ImageView robotAlert;
    private ImageView commAlert;
    private TextView batteryLevelLabel;
    private TextView teamNumber;
    private Spinner modeSpinner;
    private Spinner stationSpinner;

    SharedPreferences sharedPref;

    public int team = 0;
    private Protocol protocol = Protocol.AERIAL_ASSIST;
    private String manualIp = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());

        disableButton = root.findViewById(R.id.disableButton);
        enableButton = root.findViewById(R.id.enableButton);
        batteryLevelLabel = root.findViewById(R.id.batteryLevelLabel);
        teamNumber = root.findViewById(R.id.teamNumber);
        robotAlert = root.findViewById(R.id.robotAlert);
        commAlert = root.findViewById(R.id.commAlert);

        modeSpinner = root.findViewById(R.id.modeSpinner);
        ArrayAdapter<CharSequence> modeAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.mode, android.R.layout.simple_spinner_item);
        modeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modeSpinner.setAdapter(modeAdapter);
        modeSpinner.setOnItemSelectedListener(new ModeSpinner());

        stationSpinner = root.findViewById(R.id.stationSpinner);
        ArrayAdapter<CharSequence> stationAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.station, android.R.layout.simple_spinner_item);
        stationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stationSpinner.setAdapter(stationAdapter);
        modeSpinner.setOnItemSelectedListener(new StationSpinner());

        enableButton.setEnabled(true);
        disableButton.setEnabled(false);

        disableButton.setTextColor(Color.parseColor("#880000"));

        enableButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enableButton.setEnabled(false);
                disableButton.setEnabled(true);

                enableButton.setTextColor(Color.parseColor("#316934"));
                disableButton.setTextColor(Color.parseColor("#ffcc0000"));
            }
        });

        disableButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enableButton.setEnabled(true);
                disableButton.setEnabled(false);

                enableButton.setTextColor(Color.parseColor("#4ca050"));
                disableButton.setTextColor(Color.parseColor("#880000"));
            }
        });

        updateConfig(false);

        teamNumber.setText(Integer.toString(team));

        UIThread thread = new UIThread(batteryLevelLabel, robotAlert, commAlert, root, ClassesRunnables.HOME);
        new Thread(thread).start();
        return root;
    }

    public int getBatteryPercent(View view) {
        BatteryManager status = (BatteryManager) view.getContext().getSystemService(BATTERY_SERVICE);
        int percent = status.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        return percent;
    }

    public void updateConfig(boolean reload) {
        if (reload) {
            sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        }
        team = getTeam();
    }

    private int getTeam() {
        int team = Integer.parseInt(this.sharedPref.getString("team", "-1"));
        return team;
    }
}