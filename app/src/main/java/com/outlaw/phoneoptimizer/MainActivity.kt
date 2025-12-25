package com.outlaw.phoneoptimizer

import android.app.Activity
import android.app.ActivityManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val info = findViewById<TextView>(R.id.info)
        val button = findViewById<Button>(R.id.btnCheck)

        button.setOnClickListener {
            val am = getSystemService(ACTIVITY_SERVICE) as ActivityManager
            val memInfo = ActivityManager.MemoryInfo()
            am.getMemoryInfo(memInfo)

            val freeRam = memInfo.availMem / (1024 * 1024)
            val totalRam = memInfo.totalMem / (1024 * 1024)

            info.text = "Free RAM: $freeRam MB\nTotal RAM: $totalRam MB"
        }
    }
}
