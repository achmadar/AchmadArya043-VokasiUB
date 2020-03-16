package com.example.smartmosque

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_slideshow.*
import org.json.JSONArray
import org.json.JSONObject

class Slideshow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slideshow)

        getdariserver()

        back5.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSimpan5.setOnClickListener{

            var data_id:String =idslide.text.toString()
            var data_judul:String =editText13.text.toString()
            var data_slideshow:String =editText14.text.toString()

            postkeserver(data_judul,data_slideshow,data_id)

            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)

            Toast.makeText(getApplicationContext(), "Data Updated !", Toast.LENGTH_LONG).show()

        }

    }

    fun postkeserver(data1:String,data2: String, data3: String) {

        AndroidNetworking.post("http://mingguke4.000webhostapp.com/proses-slideshow.php")
            .addBodyParameter("judul_slideshow", data1)
            .addBodyParameter("url_slideshow", data2)
            .addBodyParameter("id_slideshow", data3)
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

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val slider=ArrayList<Slide>()

        AndroidNetworking.get("http://mingguke4.000webhostapp.com/slideshow_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object  : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response!!.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)

                        var isi1=jsonObject.optString("id_slideshow").toString()
                        var isi2=jsonObject.optString("judul_slideshow").toString()
                        var isi3=jsonObject.optString("url_slideshow").toString()

                        slider.add(Slide("ID - $isi1", "$isi2", "$isi3"))

                    }

                    val adapter=CustomAdapter(slider)
                    recyclerView.adapter=adapter
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }

            })


    }

}
