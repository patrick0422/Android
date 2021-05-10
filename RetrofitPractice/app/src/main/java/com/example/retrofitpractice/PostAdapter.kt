package com.example.retrofitpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PostAdapter(var mData: ArrayList<Post>): RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.layout_post, parent, false)

        return PostAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val item = mData[position]

        holder.title.text = item.title
        holder.time.text = item.time
        holder.writer.text = item.writer.toString()
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.postTitle)
        var time: TextView = itemView.findViewById(R.id.postTime)
        var writer: TextView = itemView.findViewById(R.id.postWriter)
    }
}