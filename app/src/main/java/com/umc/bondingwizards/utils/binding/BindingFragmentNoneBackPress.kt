package com.umc.bondingwizards.utils.binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BindingFragmentNoneBackPress<B: ViewDataBinding> (@LayoutRes private val layoutRes: Int): Fragment() {
    private var _binding: B? = null
    val binding get() = requireNotNull(_binding!!) {"${this::class.java.simpleName} ERROR"}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return binding.root
    }

}