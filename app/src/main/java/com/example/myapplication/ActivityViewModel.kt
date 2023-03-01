package com.example.myapplication

import androidx.lifecycle.ViewModel
import com.example.myapplication.core.model.InputNumber

class ActivityViewModel : ViewModel() {

    private var _inputNumber: InputNumber? = null
    private val inputNumber: InputNumber?
        get() = _inputNumber

    fun setInputNumber(inp: InputNumber) {
        _inputNumber = inp
    }
}