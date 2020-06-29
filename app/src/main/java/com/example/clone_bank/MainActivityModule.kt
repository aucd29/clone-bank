package com.example.clone_bank

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ActivityContext

//@Module
//@InstallIn(ApplicationComponent::class)
//abstract class ActivityComponents {
//    @Binds
//    abstract fun bindMainActivity(activity: MainActivity): MainActivity
//}

@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule {
    @Provides
    fun provideMainInterface(activity: Activity) : TestInterface =
        activity as TestInterface
}


//@Module
//@InstallIn(ActivityComponent::class)
//abstract class MainActivityModule {
//    @Binds
//    abstract fun bindTestInterface(activity: Activity): TestInterface
//}



