/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.libds.controller;

import me.macnolo.libds.enums.Alliance;
import me.macnolo.libds.enums.Mode;
import me.macnolo.libds.enums.Protocol;

public class LibDS {
    private int team;
    private Alliance alliance;
    private Mode mode;
    private Protocol protocol;
    private String ip;

    private Controller controller;

    public LibDS(int team, Alliance alliance, Mode mode, Protocol protocol, String ip) {
        this.team = team;
        this.alliance = alliance;
        this.mode = mode;
        this.protocol = protocol;
        this.ip = ip;

        controller = new Controller(team, alliance, mode, protocol, ip);

        controller.start();
    }

    public InterruptedException close(){
        try {
            controller.setIsRunning(false);
            controller.join();
        } catch (InterruptedException e) {
            return e;
        }
        return null;
    }
}
