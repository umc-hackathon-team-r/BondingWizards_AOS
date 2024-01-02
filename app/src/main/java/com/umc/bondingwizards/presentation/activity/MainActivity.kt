package com.umc.bondingwizards.presentation.activity

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.ActivityMainBinding
import com.umc.bondingwizards.utils.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val permissionListener: PermissionListener = object : PermissionListener {
            override fun onPermissionGranted() {
            }

            override fun onPermissionDenied(deniedPermissions: List<String?>) {
            }
        }

        TedPermission.create()
            .setPermissionListener(permissionListener)
            .setPermissions(Manifest.permission.POST_NOTIFICATIONS)
            .check()
    }
}