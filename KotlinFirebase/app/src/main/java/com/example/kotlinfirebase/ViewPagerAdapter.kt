package com.example.kotlinfirebase

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fa : FragmentActivity): FragmentStateAdapter(fa)
{
    override fun createFragment(position: Int): Fragment {
        Log.d("Yang", position.toString())
        return when(position){
            0 -> FixtureFragment()
            1 -> NewsFragment()
            2 -> NotificationFragment()
            3 -> SettingFragment()
            else -> NewsFragment()
        }
    }
    override fun getItemCount():Int = 4
}