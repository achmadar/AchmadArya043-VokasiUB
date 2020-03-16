package com.example.loginmahasiswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class Add : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btnback.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnsave.setOnClickListener{

            var data_name:String =editname.text.toString()
            var data_nim:String =editnim.text.toString()
            var data_alamat:String =editalamat.text.toString()

            postkeserver(data_name, data_nim, data_alamat)

            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)

            Toast.makeText(getApplicationContext(), "Data Inserted !", Toast.LENGTH_LONG).show()

        }
    }

    fun postkeserver(data1:String, data2: String, data3: String) {

        AndroidNetworking.post("http://mingguke4.000webhostapp.com/proses-mahasiswa.php")
            .addBodyParameter("nama_mahasiswa", data1)
            .addBodyParameter("nomer_mahasiswa", data2)
            .addBodyParameter("alamat_mahasiswa", data3)
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
