package com.umc.bondingwizards.presentation.activity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentFriendListBinding
import com.umc.bondingwizards.databinding.FragmentPresentListBinding
import com.umc.bondingwizards.domain.viewmodel.ListViewModel
import com.umc.bondingwizards.presentation.adapter.FriendListAdapter
import com.umc.bondingwizards.presentation.adapter.PresentListAdapter
import com.umc.bondingwizards.utils.binding.BindingFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListPresentFragment: BindingFragment<FragmentPresentListBinding>(R.layout.fragment_present_list) {

    private val viewModel: ListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.present = viewModel
        binding.executePendingBindings()
        binding.lifecycleOwner = viewLifecycleOwner

        setRecyclerView()
        viewModel.examplePresentList()
        binding.fabAdd.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_list,AddPresentFragment()).commit()
        }
    }

    private fun setRecyclerView() {
        val presentAdapter = PresentListAdapter(viewModel)
        binding.rvPresentList.apply {
            adapter = presentAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        viewModel.presentList.observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch (Dispatchers.Main) {
                presentAdapter.submitList(it)
            }
        }
    }

}