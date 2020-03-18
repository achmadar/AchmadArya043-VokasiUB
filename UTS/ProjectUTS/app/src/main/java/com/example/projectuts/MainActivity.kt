package com.example.projectuts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnlogout.setOnClickListener{
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@MainActivity,Login::class.java))
            finish()
        }

        button1.setOnClickListener() {
            val intent = Intent(this, PenampilPenduduk::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener() {
            val intent = Intent(this, TambahPenduduk::class.java)
            startActivity(intent)
        }

    }

}
