package com.example.categoryexample.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.categoryexample.domain.model.CategoryModel
import com.example.categoryexample.domain.model.KioskConfigModel
import com.example.categoryexample.domain.model.Model
import com.example.categoryexample.domain.repository.DataRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DataRepository) : ViewModel() {

    private val _categories = MutableLiveData<List<CategoryModel>>()
    val categories: LiveData<List<CategoryModel>> get() = _categories

    private val _models = MutableLiveData<List<Model>>()
    val models: LiveData<List<Model>> get() = _models

    private val _selectedCategory = MutableLiveData<String>()
    val selectedCategory: LiveData<String> get() = _selectedCategory

    private val _kioskConfig = MutableLiveData<KioskConfigModel>()
    val kioskConfig: LiveData<KioskConfigModel> get() = _kioskConfig

    init {
        loadCategories()
        loadKioskConfig()
    }

    private fun loadKioskConfig() {
        viewModelScope.launch {
            _kioskConfig.value = repository.getKioskConfig() // Thay đổi theo phương thức thực tế
        }
    }


    private fun loadCategories() {
        viewModelScope.launch {
            _categories.value = repository.getCategories()
            _selectedCategory.value = ""
            loadModels(_selectedCategory.value!!)
        }
    }

    fun onCategorySelected(categoryId: String) {
        _selectedCategory.value = categoryId
        loadModels(categoryId)
    }

    private fun loadModels(categoryId: String) {
        viewModelScope.launch {
            _models.value = repository.getModelsByCategory(categoryId)
        }
    }
}


class MainViewModelFactory(
    private val dataRepository: DataRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(dataRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}