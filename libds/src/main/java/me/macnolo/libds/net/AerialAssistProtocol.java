/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.libds.net;

import me.macnolo.libds.etc.Utilities;

public class AerialAssistProtocol extends SuperProtocol{

    private static String version = "v.1.0 nightly.";
    private static String name = "Aerial Assist Protocol.";

    static final int cEnabled          = 0x20;
    static final int cTestMode         = 0x02;
    static final int cAutonomous       = 0x10;
    static final int cTeleoperated     = 0x00;
    static final int cFMS_Attached     = 0x08;
    static final int cResyncComms      = 0x04;
    static final int cRebootRobot      = 0x80;
    static final int cEmergencyStopOn  = 0x00;
    static final int cEmergencyStopOff = 0x40;
    static final int cPosition1        = 0x31;
    static final int cPosition2        = 0x32;
    static final int cPosition3        = 0x33;
    static final int cAllianceRed      = 0x52;
    static final int cAllianceBlue     = 0x42;
    static final int cFMSAutonomous    = 0x53;
    static final int cFMSTeleoperated  = 0x43;

    static final int max_axes = 6;
    static final int max_hats = 0;
    static final int max_buttons = 10;
    static final int max_joysticks = 4;

    static final int resync = 1;
    static final int reboot = 0;
    static final int restart_code = 0;
}
