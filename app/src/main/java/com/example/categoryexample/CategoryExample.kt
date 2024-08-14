package com.example.categoryexample

import android.app.Application
import appModule
import org.kodein.di.DI
import org.kodein.di.DIAware

class CategoryExample : Application(), DIAware {
    override val di by DI.lazy {
        import(appModule)
    }

    companion object {
        lateinit var instance: CategoryExample
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}