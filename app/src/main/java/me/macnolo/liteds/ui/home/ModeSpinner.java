/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.liteds.ui.home;

import android.view.View;
import android.widget.AdapterView;

import me.macnolo.libds.enums.Mode;
import me.macnolo.liteds.MainActivity;

public class ModeSpinner implements AdapterView.OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String modeSelected = parent.getItemAtPosition(position).toString();
        Mode mode;

        switch(modeSelected){
            default:
                mode = Mode.TELEOP;
                break;
            case "Autonomous":
                mode = Mode.AUTO;
                break;
            case "Practice":
                mode = Mode.PRACTICE;
                break;
            case "Test":
                mode = Mode.TEST;
                break;
        }

        MainActivity main = new MainActivity();
        main.ds.setNewMode(mode);
        main.ds.updateConfig();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
