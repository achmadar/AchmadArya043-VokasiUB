package com.example.kalkulatorb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jumlahkan.setOnClickListener{

            tambah()

        }

        kurangkan.setOnClickListener{

            kurang()

        }

        kalikan.setOnClickListener{

            kali()

        }

        bagikan.setOnClickListener{

            bagi()

        }

//        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        val context = this

        BtnIntent1.setOnClickListener {

            val intent = Intent(context, Activity1::class.java)

            val name:String = inputText1.text.toString()

            intent.putExtra("nama", name)

            startActivity(intent)

            finish()

        }

        BtnIntent2.setOnClickListener {
            val intent = Intent(context, Activity2::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun tambah(){
        var bilangan1:String=bil1.text.toString()
        var bilangan2:String=bil2.text.toString()

        var a:Int=bilangan1.toInt()
        var b:Int=bilangan2.toInt()

        var c:Int=a+b

        hasil.setText(c.toString())
    }

    fun kurang(){
        var bilangan1:String=bil1.text.toString()
        var bilangan2:String=bil2.text.toString()

        var a:Int=bilangan1.toInt()
        var b:Int=bilangan2.toInt()

        var c:Int=a-b

        hasil.setText(c.toString())
    }

    fun kali(){
        var bilangan1:String=bil1.text.toString()
        var bilangan2:String=bil2.text.toString()

        var a:Int=bilangan1.toInt()
        var b:Int=bilangan2.toInt()

        var c:Int=a*b

        hasil.setText(c.toString())
    }

    fun bagi(){
        var bilangan1:String=bil1.text.toString()
        var bilangan2:String=bil2.text.toString()

        var a:Int=bilangan1.toInt()
        var b:Int=bilangan2.toInt()

        var c:Int=a/b

        hasil.setText(c.toString())
    }

}
