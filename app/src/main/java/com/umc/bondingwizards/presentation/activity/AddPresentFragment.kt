package com.umc.bondingwizards.presentation.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentAddPresentBinding
import com.umc.bondingwizards.domain.model.Present
import com.umc.bondingwizards.domain.viewmodel.ListViewModel
import com.umc.bondingwizards.presentation.adapter.FriendListAdapter
import com.umc.bondingwizards.utils.binding.BindingFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddPresentFragment: BindingFragment<FragmentAddPresentBinding>(R.layout.fragment_add_present) {

    private val viewModel: ListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.present = viewModel
        binding.executePendingBindings()
        binding.lifecycleOwner = viewLifecycleOwner

        setRecyclerView()

        binding.ivCamera.setOnClickListener {
            requestPermission()
        }
        
        binding.createBtn.setOnClickListener { 
            viewModel.addPresent(Present(price = binding.etPrice.text.toString()))
            parentFragmentManager.beginTransaction().replace(R.id.fl_list,ListPresentFragment()).commit()
        }
        binding.cancelBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_list,ListPresentFragment()).commit()
        }
    }

    private fun setRecyclerView() {
        val friendAdapter = FriendListAdapter(viewModel)
        binding.rvFriendList.apply {
            adapter = friendAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        viewModel.friendList.observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch (Dispatchers.Main) {
                friendAdapter.submitList(it)
            }
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                openGallery()
            } else {
                // Handle permission denied
            }
        }

    private fun requestPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_MEDIA_IMAGES
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
        } else {
            openGallery()
        }
    }

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val selectedImageUri = result.data?.data
                // Call a function to set the image from the URI to the ImageView
                setImageFromUri(selectedImageUri)
            }
        }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        galleryLauncher.launch(intent)
    }

    private fun setImageFromUri(imageUri: Uri?) {

    }
}