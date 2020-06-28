/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */
package me.macnolo.liteds

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

import me.macnolo.libds.controller.LibDS
import me.macnolo.libds.enums.Alliance
import me.macnolo.libds.enums.Mode
import me.macnolo.libds.enums.Protocol
import me.macnolo.liteds.ui.about.AboutActivity

class MainActivity : AppCompatActivity() {
    private var mAppBarConfiguration: AppBarConfiguration? = null
    var ds: LibDS? = null
    private var sharedPref: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_NoActionBar)
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        mAppBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_camera, R.id.nav_gamepad,
            R.id.nav_console
        )
            .setDrawerLayout(drawer)
            .build()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration!!)
        NavigationUI.setupWithNavController(navigationView, navController)
        initDS()
    }

    fun initDS() {
        ds = LibDS(
            team, Alliance.RED1, Mode.TELEOP
            , protocol, null
        )
    }

    private val team: Int
        get() = sharedPref!!.getString("team", "-1")!!.toInt()

    //Integer.parseInt(this.sharedPref.getString("protocol", "-1"));
    private val protocol: Protocol
        get() {
            val protocol: Protocol
            val protocolSelector =
                2014 //Integer.parseInt(this.sharedPref.getString("protocol", "-1"));
            protocol = when (protocolSelector) {
                2019 -> Protocol.DEEP_SPACE
                2018 -> Protocol.POWER_UP
                2017 -> Protocol.STEAMWORKS
                2016 -> Protocol.STRONGHOLD
                2015 -> Protocol.RECYCLE_RUSH
                2014 -> Protocol.AERIAL_ASSIST
                else -> Protocol.INFINITE_RECHARGE
            }
            return protocol
        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // val intentSettings = Intent(this, SettingsActivity::class.java)
                // startActivityForResult(intentSettings, 0)
                true
            }
            R.id.action_about -> {
                val intentAbout = Intent(this, AboutActivity::class.java)
                startActivityForResult(intentAbout, 0)
                super.onOptionsItemSelected(item)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        return (NavigationUI.navigateUp(navController, mAppBarConfiguration!!)
                || super.onSupportNavigateUp())
    }
}