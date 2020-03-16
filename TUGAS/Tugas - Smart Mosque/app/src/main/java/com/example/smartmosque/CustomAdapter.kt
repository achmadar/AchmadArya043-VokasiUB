package com.example.smartmosque

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val slideList: ArrayList<Slide>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: Slide=slideList[position]
        holder?.idss?.text = user.id_slide
        holder?.ss1?.text = user.judul_slide
        holder?.ss2?.text = user.url_slide
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return  ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return slideList.size
    }

    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ss1 = itemView.findViewById(R.id.ss1) as TextView
        val ss2 = itemView.findViewById(R.id.ss2) as TextView
        val idss = itemView.findViewById(R.id.idss) as TextView
    }

}