package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.ActivityMainBinding
import com.umc.bondingwizards.utils.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}