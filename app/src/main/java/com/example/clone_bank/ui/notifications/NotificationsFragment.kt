package com.example.clone_bank.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import brigitte.core.BaseFragment
import com.example.clone_bank.R
import com.example.clone_bank.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : BaseFragment<FragmentNotificationsBinding>(R.layout.fragment_notifications) {
    private val notificationsViewModel: NotificationsViewModel by viewModels()
}