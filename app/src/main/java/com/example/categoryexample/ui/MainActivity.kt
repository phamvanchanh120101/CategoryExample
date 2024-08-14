package com.example.categoryexample.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import com.example.categoryexample.R
import com.example.categoryexample.databinding.ActivityMainBinding
import com.example.categoryexample.domain.model.CategoryModel
import com.example.categoryexample.ui.component.CategoryItem
import com.example.categoryexample.ui.component.ModelItem
import com.example.categoryexample.ui.viewmodel.MainViewModel
import com.example.categoryexample.ui.viewmodel.MainViewModelFactory
import com.example.categoryexample.ui.viewmodel.SplashViewModel
import com.example.categoryexample.ui.viewmodel.SplashViewModelFactory
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.direct
import org.kodein.di.instance

class MainActivity : AppCompatActivity(), DIAware {

    override val di by closestDI()
    private val mainViewModelFactory: MainViewModelFactory
        get() = di.direct.instance()

    private val mainViewModel: MainViewModel
        get() = viewModels<MainViewModel> { mainViewModelFactory }.value


    val categoryAdapter = GroupAdapter<GroupieViewHolder>()
    val modelAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this


        binding.rvCategories.adapter = categoryAdapter
        binding.rvModels.adapter = modelAdapter

        mainViewModel.categories.observe(this) { categories ->
            categoryAdapter.update(categories.map {
                CategoryItem(it, mainViewModel)
            })
        }

        // Quan sát sự thay đổi của selectedCategory để cập nhật lại adapter
        mainViewModel.selectedCategory.observe(this) {
            categoryAdapter.notifyDataSetChanged()
        }

        mainViewModel.models.observe(this) { models ->
            modelAdapter.update(models.map { ModelItem(it) })
        }

    }
}