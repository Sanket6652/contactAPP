package com.example.signup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.signup.data.contactdata

class MyAdapte(private val userlist:ArrayList<contactdata>):RecyclerView.Adapter<MyAdapte.myviewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return myviewholder(itemView)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        val currentitem=userlist[position]
        holder.name.text=currentitem.name
        holder.phone.text=currentitem.phone
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    class myviewholder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name:TextView=itemView.findViewById(R.id.name)
        val phone:TextView=itemView.findViewById(R.id.phone)
    }
}