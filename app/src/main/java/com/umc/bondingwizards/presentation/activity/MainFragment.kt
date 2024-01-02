package com.umc.bondingwizards.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentMainBinding
import com.umc.bondingwizards.utils.binding.BindingFragment

class MainFragment: BindingFragment<FragmentMainBinding>(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBottomNavigation()
    }

    private fun initBottomNavigation() {

        activity?.supportFragmentManager!!.beginTransaction()
            .replace(R.id.main_fm, CalendarFragment())
            .commitAllowingStateLoss()
//        getSharedPreferences("a", AppCompatActivity.MODE_PRIVATE)
        binding.mainBottomNav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.calendar_nav -> {
                    activity?.supportFragmentManager!!.beginTransaction()
                        .replace(R.id.main_fm, CalendarFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.write_nav -> {
                    activity?.supportFragmentManager!!.beginTransaction()
                        .replace(R.id.main_fm, WriteFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.list_nav -> {
                    activity?.supportFragmentManager!!.beginTransaction()
                        .replace(R.id.main_fm, ListFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}