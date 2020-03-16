package com.example.smartmosque

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_jadwal.*
import org.json.JSONArray
import org.json.JSONObject

class Jadwal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal)

        getdariserver()

        back2.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSimpan2.setOnClickListener{

            var data_shubuh:String =editText3.text.toString()
            var data_dhuha:String =editText4.text.toString()
            var data_dhuhur:String =editText5.text.toString()
            var data_ashar:String =editText6.text.toString()
            var data_maghrib:String =editText7.text.toString()
            var data_isha:String =editText8.text.toString()

            postkeserver(data_shubuh,data_dhuha,data_dhuhur,data_ashar,data_maghrib,data_isha)

            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)

            Toast.makeText(getApplicationContext(), "Data Updated !", Toast.LENGTH_LONG).show()

        }

    }

    fun postkeserver(data1:String,data2:String,data3:String,data4:String,data5:String,data6:String) {

        AndroidNetworking.post("http://mingguke4.000webhostapp.com/proses-jadwal.php")
            .addBodyParameter("shubuh", data1)
            .addBodyParameter("dhuha", data2)
            .addBodyParameter("dhuhur", data3)
            .addBodyParameter("ashar", data4)
            .addBodyParameter("maghrib", data5)
            .addBodyParameter("isha", data6)
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

        AndroidNetworking.get("http://mingguke4.000webhostapp.com/jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object  : JSONObjectRequestListener{
                override fun onResponse(response: JSONObject?) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response!!.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("shubuh"))
                        Log.e("_kotlinTitle", jsonObject.optString("dhuhur"))
                        Log.e("_kotlinTitle", jsonObject.optString("ashar"))
                        Log.e("_kotlinTitle", jsonObject.optString("maghrib"))
                        Log.e("_kotlinTitle", jsonObject.optString("isha"))
                        Log.e("_kotlinTitle", jsonObject.optString("dhuha"))


                        txt1.setText(jsonObject.optString("shubuh"))
                        txt2.setText(jsonObject.optString("dhuhur"))
                        txt3.setText(jsonObject.optString("ashar"))
                        txt4.setText(jsonObject.optString("maghrib"))
                        txt5.setText(jsonObject.optString("isha"))
                        txt6.setText(jsonObject.optString("dhuha"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }

            })


    }

}
