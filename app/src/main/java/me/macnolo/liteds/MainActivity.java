/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.liteds;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import me.macnolo.libds.controller.LibDS;
import me.macnolo.libds.enums.Alliance;
import me.macnolo.libds.enums.Mode;
import me.macnolo.libds.enums.Protocol;
import me.macnolo.liteds.ui.about.AboutActivity;
import me.macnolo.liteds.ui.home.ModeSpinner;
import me.macnolo.liteds.ui.home.StationSpinner;
import me.macnolo.liteds.ui.settings.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    LibDS ds;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_camera, R.id.nav_gamepad,
                R.id.nav_console)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        initDS();
    }

    public void initDS() {
        ds = new LibDS(getTeam(), Alliance.RED1, Mode.TELEOP
                , getProtocol(), getManualIp());
    }

    private int getTeam() {
        int team = Integer.parseInt(this.sharedPref.getString("team","-1"));
        return team;
    }

    private Protocol getProtocol() {
        Protocol protocol;
        int protocolSelector = Integer.parseInt(this.sharedPref.getString("protocol", "-1"));

        switch (protocolSelector) {
            case 2019:
                protocol = Protocol.DEEP_SPACE;
                break;
            case 2018:
                protocol = Protocol.POWER_UP;
                break;
            case 2017:
                protocol = Protocol.STEAMWORKS;
                break;
            case 2016:
                protocol = Protocol.STRONGHOLD;
                break;
            case 2015:
                protocol = Protocol.RECYCLE_RUSH;
                break;
            case 2014:
                protocol = Protocol.AERIAL_ASSIST;
                break;
            default:
                protocol = Protocol.INFINITE_RECHARGE;
        }
        return protocol;
    }

    public String getManualIp() {
        boolean manualSwitch = this.sharedPref.getBoolean("manual_switch", false);
        if(manualSwitch) {
            String ip = sharedPref.getString("manual_ip", "-1");
            return ip;
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.action_settings:
                Intent intentSettings = new Intent(this, SettingsActivity.class);
                startActivityForResult(intentSettings,0);
                return true;
            case R.id.action_about:
                Intent intentAbout = new Intent(this, AboutActivity.class);
                startActivityForResult(intentAbout, 0);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static String getTeam(Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String team = sharedPref.getString("team","-1");
        return team;
    }

    public static String getProtocol(Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String protocol = sharedPref.getString("protocol", "-1");
        return protocol;
    }

    public static String getManualIp(Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        boolean manualSwitch = sharedPref.getBoolean("manual_switch", false);
        if(manualSwitch) {
            String ip = sharedPref.getString("manual_ip", "-1");
            return ip;
        }

        return null;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
