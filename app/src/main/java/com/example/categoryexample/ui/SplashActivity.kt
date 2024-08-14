package com.example.categoryexample.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.categoryexample.R
import com.example.categoryexample.ui.viewmodel.SplashViewModel
import com.example.categoryexample.ui.viewmodel.SplashViewModelFactory
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.direct
import org.kodein.di.instance

class SplashActivity : AppCompatActivity(), DIAware {
    override val di by closestDI()

    private val splashViewModelFactory: SplashViewModelFactory
        get() = di.direct.instance()

    private val splashViewModel: SplashViewModel
        get() = viewModels<SplashViewModel> { splashViewModelFactory }.value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel.dataLoaded.observe(this) { isLoaded ->
            if (isLoaded) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        splashViewModel.loadData()
    }
}
