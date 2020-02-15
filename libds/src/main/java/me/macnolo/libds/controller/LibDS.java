/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.libds.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import me.macnolo.libds.enums.Alliance;
import me.macnolo.libds.enums.IpFormats;
import me.macnolo.libds.enums.Mode;
import me.macnolo.libds.enums.Protocol;
import me.macnolo.libds.etc.IpFormater;

public class LibDS {
    private int team;
    private Alliance alliance;
    private Mode mode;
    private Protocol protocol;

    private String robotIp;
    private String fmsIp;
    private String radioIp;

    public static InetAddress ROBOT_ADDR = null;
    public static InetAddress FMS_ADDR = null;
    public static InetAddress RADIO_ADDR = null;

    private Controller controller;

    public LibDS(int team, Alliance alliance, Mode mode, Protocol protocol, String robotIp) {
        this.team = team;
        this.alliance = alliance;
        this.mode = mode;
        this.protocol = protocol;
        this.robotIp = robotIp;

        switch(protocol) {
            case AERIAL_ASSIST:
                if(robotIp == null || robotIp == ""){
                    this.robotIp = new IpFormater(this.team, IpFormats.IP_1, 1).getAddress();
                }
                this.fmsIp = new IpFormater(this.team, IpFormats.IP_1, 1).getAddress();
                this.radioIp = new IpFormater(this.team, IpFormats.IP_1, 1).getAddress();
                break;
        }

        try {
            ROBOT_ADDR = InetAddress.getByAddress(this.robotIp.getBytes());
            FMS_ADDR = InetAddress.getByAddress(this.fmsIp.getBytes());
            RADIO_ADDR = InetAddress.getByAddress(this.radioIp.getBytes());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        controller = new Controller(this.team, this.alliance, this.mode, this.protocol);

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
