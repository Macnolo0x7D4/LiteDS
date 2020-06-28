/*
 * ----------------------------------------------------------------------------
 *  Copyright (c) Manuel Diaz Rojo form WinT 3794. All Rights Reserved.
 *  Open Source Software - may be modified and shared by FRC teams.
 *  This code is under MIT License. Check LICENSE file at project root .
 * ----------------------------------------------------------------------------
 */
package me.macnolo.liteds.ui.console

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import me.macnolo.liteds.R

class ConsoleFragment : Fragment() {
    var handler = Handler()
    private var verbose: EditText? = null
    private var clearButton: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_console, container, false)
        verbose = root.findViewById(R.id.verboseText)
        clearButton = root.findViewById(R.id.clearButton)
        return root
    }
}