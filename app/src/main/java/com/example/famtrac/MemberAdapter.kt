package com.example.famtrac

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MemberAdapter(private val listMembers: List<MemberModel>) : RecyclerView.Adapter<MemberAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = inflater.inflate(R.layout.item_member,parent,false)
        return ViewHolder(item)

    }

    override fun getItemCount(): Int {
        return listMembers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listMembers[position]
        holder.name.text = item.name
    }

    class ViewHolder(private val item: View) : RecyclerView.ViewHolder(item){

        val imageUser = item.findViewById<ImageView>(R.id.img_user)
        val name = item.findViewById<ImageView>(R.id.name)




    }

}