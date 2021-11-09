package com.example.yacebook

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter

class ListAdapter(private val postList: List<Post>): RecyclerView.Adapter<ListAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount() = postList.size

    class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        //TODO 데이터 바인딩 적용해서 더러운 findViewById 치우기;;
        private val profile: ImageView = itemView.findViewById(R.id.ivProfile)
        private val name: TextView = itemView.findViewById(R.id.tvName)
        private val date: TextView = itemView.findViewById(R.id.tvDate)
        private val content: TextView = itemView.findViewById(R.id.tvContent)
        private val likeCount: TextView = itemView.findViewById(R.id.tvLikeCount)
        private val commentCount: TextView = itemView.findViewById(R.id.tvCommentCount)


        @SuppressLint("NewApi")
        fun bind(post: Post) {
            //TODO 프로필 사진 Glide로 불러오기
            profile.setImageResource(R.drawable.iu) // Glide 사용하기
            name.text = post.writer.name
            date.text = post.postedTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"))

            content.text = post.content

            likeCount.text = post.likeCount.toString()
            commentCount.text = post.commentCount.toString()
        }
    }
}