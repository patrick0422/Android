package com.example.recyclerview_diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_diffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mAdapter by lazy { MemberAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpRecyclerView()

        mAdapter.setData(
            listOf(
                MemberProfile("1", "Daniel", resources.getString(R.string.lorem)),
                MemberProfile("1", "David", resources.getString(R.string.lorem)),
                MemberProfile("1", "Silva", resources.getString(R.string.lorem)),
                MemberProfile("1", "Ederson", resources.getString(R.string.lorem)),
                MemberProfile("1", "Sterling", resources.getString(R.string.lorem)),
                MemberProfile("1", "Zinchenko", resources.getString(R.string.lorem)),
                MemberProfile("1", "Gundogan", resources.getString(R.string.lorem)),
                MemberProfile("1", "Mendy", resources.getString(R.string.lorem)),
                MemberProfile("1", "Cancelo", resources.getString(R.string.lorem)),
                MemberProfile("1", "Rodri", resources.getString(R.string.lorem)),
                MemberProfile("1", "Jesus", resources.getString(R.string.lorem)),
                MemberProfile("1", "De Bruyne", resources.getString(R.string.lorem)),
                MemberProfile("1", "Mahrez", resources.getString(R.string.lorem)),
                MemberProfile("1", "Dias", resources.getString(R.string.lorem)),
                MemberProfile("1", "Stones", resources.getString(R.string.lorem)),
                MemberProfile("1", "Laporte", resources.getString(R.string.lorem)),
                MemberProfile("1", "Ake", resources.getString(R.string.lorem)),
                MemberProfile("1", "Torres", resources.getString(R.string.lorem)),
                MemberProfile("1", "Walker", resources.getString(R.string.lorem)),
                )
        )
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.adapter = mAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}