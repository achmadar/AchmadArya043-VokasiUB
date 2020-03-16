package com.example.loginmahasiswa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val mhsList: ArrayList<Mahasiswa>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datamhs: Mahasiswa=mhsList[position]
        holder?.mhsid?.text = datamhs.id_data
        holder?.mhs1?.text = datamhs.nama_mahasiswa
        holder?.mhs2?.text = datamhs.nomer_mahasiswa
        holder?.mhs3?.text = datamhs.alamat_mahasiswa
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return  ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return mhsList.size
    }

    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val mhsid = itemView.findViewById(R.id.mhsid) as TextView
        val mhs1 = itemView.findViewById(R.id.mhs1) as TextView
        val mhs2 = itemView.findViewById(R.id.mhs2) as TextView
        val mhs3 = itemView.findViewById(R.id.mhs3) as TextView
    }

}