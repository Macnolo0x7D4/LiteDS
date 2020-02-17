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

public class ModeSpinner implements AdapterView.OnItemSelectedListener {
    private String modeSelected;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        modeSelected = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        modeSelected = "TeleOperated";
    }

    public Mode getModeSelected(){
        switch(modeSelected){
            default:
                return Mode.TELEOP;
            case "Autonomous":
                return Mode.AUTO;
            case "Practice":
                return Mode.PRACTICE;
            case "Test":
                return Mode.TEST;
        }
    }
}
