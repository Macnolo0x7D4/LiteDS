/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.libds.controller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import me.macnolo.libds.enums.Alliance;
import me.macnolo.libds.enums.Mode;
import me.macnolo.libds.enums.PackageTypes;
import me.macnolo.libds.enums.Protocol;
import me.macnolo.libds.etc.Utilities;
import me.macnolo.libds.object.NetPackage;

public class Controller extends Thread {
    private int team;
    private Alliance alliance;
    private Mode mode;
    private Protocol protocol;
    private String ip;

    private byte[] data;
    private String origin;

    private boolean isRunning = false;

    public Controller(int team, Alliance alliance, Mode mode, Protocol protocol, String ip) {
        this.team = team;
        this.alliance = alliance;
        this.mode = mode;
        this.protocol = protocol;
        this.ip = ip;
    }

    @Override
    public void run() {
        try {
            DatagramSocket udp = new DatagramSocket(Utilities.PORT);

            while (isRunning) {
                NetPackage pkg = new NetPackage(PackageTypes.FMS);
                DatagramPacket dataPkg = new DatagramPacket(pkg.getPackage(), pkg.getPackage().length);

                udp.receive(dataPkg);

                data = dataPkg.getData();
                origin = dataPkg.getAddress().toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean isRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean running) {
        isRunning = running;
    }
}
