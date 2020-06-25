package com.example.clone_bank.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import brigitte.core.BaseFragment
import com.example.clone_bank.R
import com.example.clone_bank.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>(R.layout.fragment_dashboard) {
    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}