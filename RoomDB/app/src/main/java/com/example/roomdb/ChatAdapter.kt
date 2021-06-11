package com.example.roomdb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private var chatList: ArrayList<Chat>) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
//
//    class ViewHolder(itemView: View, var textView: TextView) : RecyclerView.ViewHolder(itemView) {
//        init {
//            textView = itemView.findViewById(R.id.content)
//        }
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.item_chat, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        var chat = chatList[position]

        holder.content.text = chat.content
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val content: TextView = view.findViewById(R.id.content)
    }
}