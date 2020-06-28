/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */
package me.macnolo.liteds.ui

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import me.macnolo.liteds.ui.ClassesRunnables
import me.macnolo.liteds.ui.console.ConsoleFragment
import me.macnolo.liteds.ui.home.HomeFragment

class UIThread : Runnable {
    private val home: HomeFragment = HomeFragment()
    private val console: ConsoleFragment = ConsoleFragment()
    private var t: TextView? = null
    private var et: EditText? = null
    private var robotAlert: ImageView? = null
    private var commAlert: ImageView? = null
    private var view: View
    private var type: ClassesRunnables
    private val id = 0

    constructor(
        t: TextView?,
        robotAlert: ImageView?,
        commAlert: ImageView?,
        view: View,
        type: ClassesRunnables
    ) {
        this.t = t
        this.view = view
        this.type = type
        this.robotAlert = robotAlert
        this.commAlert = commAlert
    }

    constructor(et: EditText?, view: View, type: ClassesRunnables) {
        this.et = et
        this.view = view
        this.type = type
    }

    override fun run() {
        /*when (type) {
            ClassesRunnables.HOME -> home.handler.post(Runnable { /*int robotStatus;
                        int commStatus;
*/
                val battery: Int = home.getBatteryPercent(view)
                t!!.text = "$battery%"
                /*
                            byte[] data = new MainActivity().ds.getData();

                            robotStatus = data[0] == 0 ? Utilities.COLOR_ACTIVE_RED : Utilities.COLOR_ACTIVE_GREEN;
                            commStatus = data[1] == 0 ? Utilities.COLOR_ACTIVE_RED : Utilities.COLOR_ACTIVE_GREEN;

                            robotAlert.setBackgroundColor(robotStatus);
                            commAlert.setBackgroundColor(commStatus);*/
            })
            ClassesRunnables.CAMERA -> {
            }
            ClassesRunnables.GAMEPAD -> {
            }
            ClassesRunnables.CONSOLE -> console.handler.post(Runnable { })
        } */
    }
}