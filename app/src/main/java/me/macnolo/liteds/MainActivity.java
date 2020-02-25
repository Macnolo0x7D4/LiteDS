/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */

package me.macnolo.liteds;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

import com.google.android.material.navigation.NavigationView;

import me.macnolo.libds.controller.LibDS;
import me.macnolo.libds.enums.Alliance;
import me.macnolo.libds.enums.Mode;
import me.macnolo.libds.enums.Protocol;
import me.macnolo.liteds.ui.about.AboutActivity;
import me.macnolo.liteds.ui.settings.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    public LibDS ds;
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
                , getProtocol(), null);
    }

    private int getTeam() {
        return Integer.parseInt(this.sharedPref.getString("team", "-1"));
    }

    private Protocol getProtocol() {
        Protocol protocol;
        int protocolSelector = 2014; //Integer.parseInt(this.sharedPref.getString("protocol", "-1"));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intentSettings = new Intent(this, SettingsActivity.class);
                startActivityForResult(intentSettings, 0);
                return true;
            case R.id.action_about:
                Intent intentAbout = new Intent(this, AboutActivity.class);
                startActivityForResult(intentAbout, 0);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
