/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.liteds;

import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import me.macnolo.libds.etc.Utilities;
import me.macnolo.liteds.ui.ClassesRunnables;
import me.macnolo.liteds.ui.console.ConsoleFragment;
import me.macnolo.liteds.ui.home.HomeFragment;

public class UIThread implements Runnable{
    private HomeFragment home = new HomeFragment();
    private ConsoleFragment console = new ConsoleFragment();

    private TextView t;
    private EditText et;
    private ImageView robotAlert;
    private ImageView commAlert;
    private View view;
    private ClassesRunnables type;
    private int id = 0;

    public UIThread(TextView t, ImageView robotAlert, ImageView commAlert,View view, ClassesRunnables type) {
        this.t = t;
        this.view = view;
        this.type = type;

        this.robotAlert = robotAlert;
        this.commAlert = commAlert;
    }

    public UIThread(EditText et, View view, ClassesRunnables type) {
        this.et = et;
        this.view = view;
        this.type = type;
    }

    @Override
    public void run(){
        switch(type){
            case HOME:
                home.handler.post(new Runnable() {
                    private MainActivity main;
                    private byte[] data = new byte[Utilities.DATA_TRANSFER_LENGHT];

                    private int robotStatus;
                    private int commStatus;


                    @Override
                    public void run() {
                        int battery = home.getBatteryPercent(view);
                        t.setText(battery + "%");
                        data = main.ds.getData();

                        robotStatus = data[0] == 0 ? Utilities.COLOR_ACTIVE_RED : Utilities.COLOR_ACTIVE_GREEN;
                        commStatus = data[1] == 0 ? Utilities.COLOR_ACTIVE_RED : Utilities.COLOR_ACTIVE_GREEN;

                        robotAlert.setBackgroundColor(robotStatus);
                        commAlert.setBackgroundColor(commStatus);
                    }
                });
                break;
            case CAMERA:
                break;
            case GAMEPAD:
                break;
            case CONSOLE:
                console.handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
                break;
        }
    }
}
