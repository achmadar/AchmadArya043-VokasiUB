package com.example.smartmosque

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_pengumuman.*
import org.json.JSONArray
import org.json.JSONObject

class Pengumuman : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengumuman)

        getdariserver()

        back4.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSimpan4.setOnClickListener{

            var data_judul:String =editText10.text.toString()
            var data_isi:String =editText11.text.toString()

            postkeserver(data_judul,data_isi)

            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)

            Toast.makeText(getApplicationContext(), "Data Updated !", Toast.LENGTH_LONG).show()

        }

    }

    fun postkeserver(data1:String,data2:String) {

        AndroidNetworking.post("http://mingguke4.000webhostapp.com/proses-pengumuman.php")
            .addBodyParameter("judul_pengumuman", data1)
            .addBodyParameter("isi_pengumuman", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {

                override fun onResponse(response: JSONArray?) {

                }

                override fun onError(error: ANError?){

                }
            })

    }

    fun getdariserver(){

        AndroidNetworking.get("http://mingguke4.000webhostapp.com/pengumuman_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object  : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response!!.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)

                        pgm1.setText(jsonObject.optString("judul_pengumuman"))
                        pgm2.setText(jsonObject.optString("isi_pengumuman"))

                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }

            })


    }

}
