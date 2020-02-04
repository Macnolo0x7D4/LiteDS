/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.liteds.protocol;

public class LogConstants {
    static final String DB_NAME = "liteds";

    static final String TABLE = "logs";
    static final String ID = "id";
    static final String ORIGIN = "origin";
    static final String TYPE = "type";
    static final String LOG = "log";

    static final String CREATE = "CREATE TABLE " + TABLE + " (" + ID + " INTEGER, " + ORIGIN + " TEXT, " + TYPE + " INTEGER, " + LOG + " TEXT)";
    static final String UPDATE = "DROP TABLE IF EXISTS " + TABLE;
}
