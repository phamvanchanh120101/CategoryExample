package com.example.categoryexample.ui.component

import com.example.categoryexample.R
import com.example.categoryexample.databinding.ModelItemBinding
import com.example.categoryexample.domain.model.Model
import com.xwray.groupie.databinding.BindableItem

class ModelItem(private val model: Model) : BindableItem<ModelItemBinding>() {

    override fun getLayout() = R.layout.model_item

    override fun bind(viewBinding: ModelItemBinding, position: Int) {
        viewBinding.model = model
    }
}