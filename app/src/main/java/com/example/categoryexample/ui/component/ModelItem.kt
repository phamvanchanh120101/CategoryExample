package com.example.categoryexample.ui.component

import com.example.categoryexample.R
import com.example.categoryexample.databinding.ModelItem1Binding
import com.example.categoryexample.domain.model.Model
import com.xwray.groupie.databinding.BindableItem

class ModelItem(private val model: Model) : BindableItem<ModelItem1Binding>() {

    override fun getLayout() = R.layout.model_item1

    override fun bind(viewBinding: ModelItem1Binding, position: Int) {
        viewBinding.model = model
    }
}