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
import me.macnolo.liteds.MainActivity;

public class StationSpinner implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String stationSelected = parent.getItemAtPosition(position).toString();
        Alliance alliance;

        switch (stationSelected){
            default:
                alliance = Alliance.RED1;
                break;
            case "Red 2":
                alliance = Alliance.RED2;
                break;
            case "Red 3":
                alliance = Alliance.RED3;
                break;
            case "Blue 1":
                alliance = Alliance.BLUE1;
                break;
            case "Blue 2":
                alliance = Alliance.BLUE2;
                break;
            case "Blue 3":
                alliance = Alliance.BLUE3;
                break;
        }

        MainActivity main = new MainActivity();
        main.ds.setNewAlliance(alliance);
        main.ds.updateConfig();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
