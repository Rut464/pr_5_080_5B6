package com.example.pr_5_080_5b6

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        implicitIntent()
    }
    private fun implicitIntent(){
        //browse
        findViewById<Button>(R.id.browser).setOnClickListener {
            Intent(Intent.ACTION_VIEW,
            Uri.parse(findViewById<EditText>(R.id.edittxt).text.toString())).also { startActivity(it)}
        }
        //call
        findViewById<Button>(R.id.call_btn).setOnClickListener {
            val number=findViewById<EditText>(R.id.input_call).text.toString().trim()
            Intent(Intent.ACTION_DIAL).setData((Uri.parse("tel:$number"))).apply{startActivity(this)}
        }
        //call log
        findViewById<Button>(R.id.call_log_btn).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) } }
        //Gallery
        findViewById<Button>(R.id.gallary_btn).setOnClickListener {
            Intent(
            Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) } }
        //camera
        findViewById<Button>(R.id.camera_btn).setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) } }
        //alarm
        findViewById<Button>(R.id.alarm_btn).setOnClickListener {
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
        }
    }
    }
