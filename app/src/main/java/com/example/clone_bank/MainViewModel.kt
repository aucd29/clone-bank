package com.example.clone_bank

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(
    var t: TestInterface
) : ViewModel() {

//    @Inject lateinit var t: TestInterface

    init {
        Timber.d("init")
    }

    fun onTest() {
        t.test()
    }

}