package com.example.recyclerview_diffutil

import androidx.recyclerview.widget.DiffUtil

class MemberDiffUtil(
    private val oldList: List<MemberProfile>,
    private val newList: List<MemberProfile>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] === newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

}