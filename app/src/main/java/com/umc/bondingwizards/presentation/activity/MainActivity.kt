package com.naze.common.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.naze.common.R
import com.naze.common.databinding.ActivityMainBinding
import com.umc.bondingwizards.domain.viewmodel.DummyViewModel
import com.umc.bondingwizards.utils.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: DummyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner
    }
}