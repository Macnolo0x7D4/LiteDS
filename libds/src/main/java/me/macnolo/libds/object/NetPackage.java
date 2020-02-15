/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.libds.object;

import me.macnolo.libds.enums.PackageTypes;

public class NetPackage {
    private byte[] pkg = new byte[1024];

    public NetPackage(PackageTypes pkg) {
        switch (pkg) {
            case FMS:
                break;
            case RADIO:
                break;
            case ROBOT:
                break;
        }
    }

    public byte[] getPackage() {
        return pkg;
    }
}
