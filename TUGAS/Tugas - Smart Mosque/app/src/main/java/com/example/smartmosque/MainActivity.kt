package com.example.smartmosque

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener() {
            val intent = Intent(this, Identitas::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener() {
            val intent = Intent(this, Jadwal::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener() {
            val intent = Intent(this, Marquee::class.java)
            startActivity(intent)
        }

        button4.setOnClickListener() {
            val intent = Intent(this, Pengumuman::class.java)
            startActivity(intent)
        }

        button5.setOnClickListener() {
            val intent = Intent(this, Slideshow::class.java)
            startActivity(intent)
        }

        button6.setOnClickListener() {
            val intent = Intent(this, Tagline::class.java)
            startActivity(intent)
        }

    }
}
