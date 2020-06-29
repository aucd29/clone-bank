package com.example.clone_bank

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import brigitte.core.BaseActivity
import com.example.clone_bank.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main), TestInterface {
//    @Inject
//    lateinit var appBarConfig: AppBarConfiguration

    val viewmodel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("HELLO MAIN ACTIVITY")

        viewmodel.onTest()
//        testInterface.test()


//        val navController = findNavController(R.id.nav_host_fragment)
//
//        setupActionBarWithNavController(navController, appBarConfig)
//        binding.navView.setupWithNavController(navController)
    }

    fun test2() {

    }

    override fun test() {
        Timber.d("TEST INTERFACE")
    }
}