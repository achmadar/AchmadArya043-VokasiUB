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
import kotlinx.android.synthetic.main.activity_identitas.*
import org.json.JSONArray
import org.json.JSONObject

class Identitas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identitas)

        getdariserver()

        btnSimpan1.setOnClickListener{

            var data_namamasjid:String =editText.text.toString()
            var data_alamatmasjid:String =editText2.text.toString()

            postkeserver(data_namamasjid,data_alamatmasjid)

            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)

            Toast.makeText(getApplicationContext(), "Data Updated !", Toast.LENGTH_LONG).show()

        }

        back1.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun getdariserver(){

        AndroidNetworking.get("http://mingguke4.000webhostapp.com/identitas_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object  : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response!!.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)

                        nama1.setText(jsonObject.optString("nama_masjid"))
                        nama2.setText(jsonObject.optString("alamat_masjid"))

                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }

            })

    }

    fun postkeserver(data1:String,data2:String) {

        AndroidNetworking.post("http://mingguke4.000webhostapp.com/proses-identitas.php")
            .addBodyParameter("nama_masjid", data1)
            .addBodyParameter("alamat_masjid", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {

                override fun onResponse(response: JSONArray?) {

                }

                override fun onError(error: ANError?){

                }
            })

    }

}
