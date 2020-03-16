package com.example.kalkulatorb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_1.*
import kotlinx.android.synthetic.main.activity_main.*

class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val intentObject:Intent=intent

        val name=intentObject.getStringExtra("name")

        textView.text = "Hey $name"

        val context = this

        BtnIntentUtama1.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
