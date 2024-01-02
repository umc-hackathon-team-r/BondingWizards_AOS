package com.umc.bondingwizards.presentation.activity

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.messaging.FirebaseMessaging
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.ActivityMainBinding
import com.umc.bondingwizards.utils.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    val TAG = "seeToken"

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

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val token = task.result
                // Use the token as needed
                Log.d(TAG, token)
            } else {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
            }
        }
    }
}