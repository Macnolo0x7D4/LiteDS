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

import me.macnolo.libds.enums.Alliance;

public class StationSpinner implements AdapterView.OnItemSelectedListener {
    private String stationSelected;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        stationSelected = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        stationSelected = "Red 1";
    }

    public Alliance getStationSelected() {
        switch (stationSelected){
            default:
                return Alliance.RED1;
            case "Red 2":
                return Alliance.RED2;
            case "Red 3":
                return Alliance.RED3;
            case "Blue 1":
                return Alliance.BLUE1;
            case "Blue 2":
                return Alliance.BLUE2;
            case "Blue 3":
                return Alliance.BLUE3;
        }
    }
}
