package com.example.myrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerPostAdapter(private var postList: ArrayList<Post>) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.layout_post, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var post = postList[position]

        holder.title.text = post.title
        holder.time.text = post.time
        holder.writer.text = post.writer.toString()
    }

    override fun getItemCount(): Int = postList.size

}

class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var title: TextView = view.findViewById(R.id.postTitle)
    val time: TextView = view.findViewById(R.id.postTime)
    val writer: TextView = view.findViewById(R.id.postWriter)
}