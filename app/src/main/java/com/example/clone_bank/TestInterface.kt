package com.example.clone_bank

import timber.log.Timber
import javax.inject.Inject

interface TestInterface {
    fun test()
}

class Test2 @Inject constructor() {
    fun test() {
        Timber.d("DDD")
    }
}