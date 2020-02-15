/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.libds.net;

public class ProtocolController {
    private static boolean enableOp = false;
    private static boolean isRunning = false;

    private static int sentFMSPackets = 0;
    private static int sentRadioPackets = 0;
    private static int sentRobotPackets = 0;
    private static int recFMSPackets = 0;
    private static int recRadioPackets = 0;
    private static int recRobotPackets = 0;

    public static void sendFMSData() {
        if (enableOp) {
            sentFMSPackets++;
        }
    }
}
