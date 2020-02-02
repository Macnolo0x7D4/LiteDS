package me.macnolo.liteds.ui.home;

import android.os.BatteryManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import me.macnolo.liteds.MainActivity;
import me.macnolo.liteds.R;

import static android.content.Context.BATTERY_SERVICE;

public class HomeFragment extends Fragment{

    private Button disableButton;
    private Button enableButton;

    private TextView batteryLevelLabel;
    private BatteryManager batteryStatus;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        disableButton = root.findViewById(R.id.disableButton);
        enableButton = root.findViewById(R.id.enableButton);
        batteryLevelLabel = root.findViewById(R.id.batteryLevelLabel);
        batteryStatus = (BatteryManager) root.getContext().getSystemService(BATTERY_SERVICE);

        enableButton.setEnabled(true);
        disableButton.setEnabled(false);

        enableButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enableButton.setEnabled(false);
                disableButton.setEnabled(true);
            }
        });

        disableButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                enableButton.setEnabled(true);
                disableButton.setEnabled(false);
            }
        });

        return root;
    }
}