package com.example.yacebook

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ListAdapter(private val postList: List<Post>): RecyclerView.Adapter<ListAdapter.PostViewHolder>() {
    class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val profile: ImageView = itemView.findViewById(R.id.ivProfile)
        private val name: TextView = itemView.findViewById(R.id.tvName)
        private val date: TextView = itemView.findViewById(R.id.tvDate)
        private val content: TextView = itemView.findViewById(R.id.tvContent)
        private val likeCount: TextView = itemView.findViewById(R.id.tvLikeCount)
        private val commentCount: TextView = itemView.findViewById(R.id.tvCommentCount)

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(post: Post) {
//            profile.setImageResource() // Glide 사용하기
            name.text = post.writer.name
            date.text = post.postedTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"))

            content.text = post.content

            likeCount.text = post.likeCount.toString()
            commentCount.text = post.commentCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)

        return PostViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount() = postList.size
}