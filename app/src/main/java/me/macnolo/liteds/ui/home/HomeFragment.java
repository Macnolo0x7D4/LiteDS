package me.macnolo.liteds.ui.home;

import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import me.macnolo.liteds.MainActivity;
import me.macnolo.liteds.R;
import me.macnolo.liteds.UIThread;
import me.macnolo.liteds.ui.ClassesRunnables;

import static android.content.Context.BATTERY_SERVICE;

public class HomeFragment extends Fragment{

    public Handler handler = new Handler();

    private Button disableButton;
    private Button enableButton;

    private TextView batteryLevelLabel;
    private TextView teamNumber;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        disableButton = root.findViewById(R.id.disableButton);
        enableButton = root.findViewById(R.id.enableButton);
        batteryLevelLabel = root.findViewById(R.id.batteryLevelLabel);
        teamNumber = root.findViewById(R.id.teamNumber);

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
            public void onClick (View v) {
                enableButton.setEnabled(true);
                disableButton.setEnabled(false);

                enableButton.setTextColor(Color.parseColor("#4ca050"));
                disableButton.setTextColor(Color.parseColor("#880000"));
            }
        });

        UIThread thread = new UIThread(batteryLevelLabel, root, ClassesRunnables.HOME);
        new Thread(thread).start();

        teamNumber.setText(MainActivity.getTeam(super.getContext()));

        return root;
    }

    public int getBatteryPercent(View view){
        BatteryManager status = (BatteryManager)view.getContext().getSystemService(BATTERY_SERVICE);
        int percent = status.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        return percent;
    }
}