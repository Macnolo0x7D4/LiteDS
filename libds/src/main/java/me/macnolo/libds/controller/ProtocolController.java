/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.libds.controller;

import me.macnolo.libds.enums.Protocol;
import me.macnolo.libds.net.AerialAssistProtocol;
import me.macnolo.libds.net.SuperProtocol;

public class ProtocolController {
    private SuperProtocol superProtocol;

    public ProtocolController (Protocol protocol){
        switch (protocol){
            case INFINITE_RECHARGE:
                break;
            case DEEP_SPACE:
                break;
            case STRONGHOLD:
                break;
            case RECYCLE_RUSH:
                break;
            case AERIAL_ASSIST:
                superProtocol = new AerialAssistProtocol();
        }
    }

    public SuperProtocol getSuperProtocol(){
        return superProtocol;
    }
}
