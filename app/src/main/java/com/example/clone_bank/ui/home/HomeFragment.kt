package com.example.clone_bank.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import brigitte.core.BaseFragment
import com.example.clone_bank.R
import com.example.clone_bank.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}