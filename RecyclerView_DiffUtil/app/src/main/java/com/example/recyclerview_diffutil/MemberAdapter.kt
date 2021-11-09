package com.example.recyclerview_diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_diffutil.databinding.ListItemBinding

class MemberAdapter : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {
    private var memberList = emptyList<MemberProfile>()

    class MemberViewHolder(private var binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(member: MemberProfile) {
            binding.member = member
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MemberViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)

                return MemberViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder =
        MemberViewHolder.from(parent)

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.bind(memberList[position])
    }

    override fun getItemCount(): Int = memberList.size

    fun setData(newMemberList: List<MemberProfile>) {
        val memberDiffUtil = MemberDiffUtil(memberList, newMemberList)
        val diffUtilResult = DiffUtil.calculateDiff(memberDiffUtil)

        memberList = newMemberList

        diffUtilResult.dispatchUpdatesTo(this)
    }
}