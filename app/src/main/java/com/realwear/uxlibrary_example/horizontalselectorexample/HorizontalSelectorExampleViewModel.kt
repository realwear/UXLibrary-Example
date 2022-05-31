package com.realwear.uxlibrary_example.horizontalselectorexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class HorizontalSelectorExampleViewModel : ViewModel() {

    fun getArray() = liveData(Dispatchers.IO) {
        emit(DataSource.arr)
    }
}