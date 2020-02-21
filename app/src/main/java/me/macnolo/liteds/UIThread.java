/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.liteds;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import me.macnolo.liteds.ui.ClassesRunnables;
import me.macnolo.liteds.ui.console.ConsoleFragment;
import me.macnolo.liteds.ui.home.HomeFragment;

public class UIThread implements Runnable{
    private HomeFragment home = new HomeFragment();
    private ConsoleFragment console = new ConsoleFragment();

    private TextView t;
    private EditText et;
    private View view;
    private ClassesRunnables type;
    private int id = 0;

    public UIThread(TextView t, View view, ClassesRunnables type) {
        this.t = t;
        this.view = view;
        this.type = type;
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

                    @Override
                    public void run() {
                        int battery = home.getBatteryPercent(view);
                        t.setText(battery + "%");
                        main.ds.getData();

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
