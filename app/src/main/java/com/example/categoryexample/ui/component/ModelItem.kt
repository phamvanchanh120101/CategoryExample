package com.example.categoryexample.ui.component

import com.example.categoryexample.R
import com.example.categoryexample.databinding.ItemModelBinding
import com.example.categoryexample.domain.model.Model
import com.xwray.groupie.databinding.BindableItem

class ModelItem(private val model: Model) : BindableItem<ItemModelBinding>() {

    override fun getLayout() = R.layout.item_model

    override fun bind(viewBinding: ItemModelBinding, position: Int) {
        viewBinding.model = model
    }
}