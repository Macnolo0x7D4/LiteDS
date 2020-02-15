/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.libds.net;

import me.macnolo.libds.etc.Utilities;

public abstract class SuperProtocol {

    public static String getVersion(){
        return version;
    }

    public static String getName() {
        return name;
    }

    public static String getInfo() {
        return getName() + " " + getVersion() + Utilities.CREDITS_PROTOCOL;
    }

    private static String version = "v.1.0 nightly.";
    private static String name = "Aerial Assist Protocol.";

    static final int cEnabled          = 0x0;
    static final int cTestMode         = 0x0;
    static final int cAutonomous       = 0x0;
    static final int cTeleoperated     = 0x0;
    static final int cFMS_Attached     = 0x0;
    static final int cResyncComms      = 0x0;

    static final int cRebootRobot      = 0x0;
    static final int cEmergencyStopOn  = 0x0;
    static final int cEmergencyStopOff = 0x0;
    static final int cPosition1        = 0x0;
    static final int cPosition2        = 0x0;
    static final int cPosition3        = 0x0;
    static final int cAllianceRed      = 0x0;
    static final int cAllianceBlue     = 0x0;
    static final int cFMSAutonomous    = 0x0;
    static final int cFMSTeleoperated  = 0x0;

    static final int max_axes = 0;
    static final int max_hats = 0;
    static final int max_buttons = 0;
    static final int max_joysticks = 0;

    static final int resync = 0;
    static final int reboot = 0;
    static final int restart_code = 0;

    public static int getcEnabled() {
        return cEnabled;
    }

    public static int getcTestMode() {
        return cTestMode;
    }

    public static int getcAutonomous() {
        return cAutonomous;
    }

    public static int getcTeleoperated() {
        return cTeleoperated;
    }

    public static int getcFMS_Attached() {
        return cFMS_Attached;
    }

    public static int getcResyncComms() {
        return cResyncComms;
    }

    public static int getcRebootRobot() {
        return cRebootRobot;
    }

    public static int getcEmergencyStopOn() {
        return cEmergencyStopOn;
    }

    public static int getcEmergencyStopOff() {
        return cEmergencyStopOff;
    }

    public static int getcPosition1() {
        return cPosition1;
    }

    public static int getcPosition2() {
        return cPosition2;
    }

    public static int getcPosition3() {
        return cPosition3;
    }

    public static int getcAllianceRed() {
        return cAllianceRed;
    }

    public static int getcAllianceBlue() {
        return cAllianceBlue;
    }

    public static int getcFMSAutonomous() {
        return cFMSAutonomous;
    }

    public static int getcFMSTeleoperated() {
        return cFMSTeleoperated;
    }

    public static int getMax_axes() {
        return max_axes;
    }

    public static int getMax_hats() {
        return max_hats;
    }

    public static int getMax_buttons() {
        return max_buttons;
    }

    public static int getMax_joysticks() {
        return max_joysticks;
    }

    public static int getResync() {
        return resync;
    }

    public static int getReboot() {
        return reboot;
    }

    public static int getRestart_code() {
        return restart_code;
    }
}
