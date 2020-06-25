package com.example.clone_bank.ui.notifications

import androidx.fragment.app.viewModels
import brigitte.core.BaseFragment
import com.example.clone_bank.R
import com.example.clone_bank.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : BaseFragment<FragmentNotificationsBinding>(R.layout.fragment_notifications) {
    private val notificationsViewModel: NotificationsViewModel by viewModels()
}