package com.example.floating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFab = findViewById<FloatingActionButton>(R.id.alert)
        mFab.setOnClickListener {
            Toast.makeText(this@MainActivity, "FAB is clicked...", Toast.LENGTH_LONG).show()
        }

    }
}
