package com.example.projectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_tambah_penduduk.*
import org.json.JSONArray

class TambahPenduduk : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_penduduk)

        btnsave.setOnClickListener {

            var data_name: String = editname.text.toString()
            var data_ttl: String = editttl.text.toString()
            var data_hp: String = edithp.text.toString()
            var data_alamat: String = editalamat.text.toString()

            postkeserver(data_name, data_ttl, data_hp, data_alamat)

            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)

            Toast.makeText(getApplicationContext(), "Data Inserted !", Toast.LENGTH_LONG).show()

        }
    }

        fun postkeserver(data1:String, data2: String, data3: String, data4: String) {

            AndroidNetworking.post("http://192.168.1.89/penduduk/proses-penduduk.php")
                .addBodyParameter("nama_penduduk", data1)
                .addBodyParameter("ttl_penduduk", data2)
                .addBodyParameter("hp_penduduk", data3)
                .addBodyParameter("alamat_penduduk", data4)
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
