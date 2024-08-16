package com.example.categoryexample.ui.component

import com.example.categoryexample.R
import com.example.categoryexample.databinding.ItemCategoryBinding
import com.example.categoryexample.domain.model.CategoryModel
import com.example.categoryexample.ui.viewmodel.MainViewModel
import com.xwray.groupie.databinding.BindableItem

class CategoryItem(
    private val category: CategoryModel,
    private val viewModel: MainViewModel,

) : BindableItem<ItemCategoryBinding>() {

    override fun getLayout() = R.layout.item_category

    override fun bind(viewBinding: ItemCategoryBinding, position: Int) {
        // Gán dữ liệu vào DataBinding
        viewBinding.category = category
        viewBinding.viewModel = viewModel

        val isSelected = viewModel.selectedCategory.value == category.id
        viewBinding.isSelected = isSelected
    }
}