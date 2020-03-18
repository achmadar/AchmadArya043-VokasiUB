package com.example.projectuts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_penampil_penduduk.*
import org.json.JSONObject

class PenampilPenduduk : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penampil_penduduk)

        getdariserver()

        back1.setOnClickListener{

            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }

    fun getdariserver(){

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val pdd=ArrayList<Penduduk>()

        AndroidNetworking.get("http://192.168.1.89/penduduk/penduduk_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object  : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response!!.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)

                        var isi1=jsonObject.optString("id_data").toString()
                        var isi2=jsonObject.optString("nama_penduduk").toString()
                        var isi3=jsonObject.optString("ttl_penduduk").toString()
                        var isi4=jsonObject.optString("hp_penduduk").toString()
                        var isi5=jsonObject.optString("alamat_penduduk").toString()

                        pdd.add(Penduduk("ID - $isi1", "$isi2", "$isi3","$isi4","$isi5"))

                    }

                    val adapter=CustomAdapter(pdd)
                    recyclerView.adapter=adapter
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }

            })


    }

}
