package com.example.projectuts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val pddList: ArrayList<Penduduk>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datapdd: Penduduk = pddList[position]
        holder?.pdd1?.text = datapdd.nama_penduduk
        holder?.pdd2?.text = datapdd.ttl_penduduk
        holder?.pdd3?.text = datapdd.hp_penduduk
        holder?.pdd4?.text = datapdd.alamat_penduduk
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return pddList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pdd1 = itemView.findViewById(R.id.pdd1) as TextView
        val pdd2 = itemView.findViewById(R.id.pdd2) as TextView
        val pdd3 = itemView.findViewById(R.id.pdd3) as TextView
        val pdd4 = itemView.findViewById(R.id.pdd4) as TextView
    }

}