package com.example.mealsapp.mealdetail
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import com.example.mealsapp.navigation.response.DetailResponse

class mealdetailviewmodel(private val service: MealDetailsService = MealDetailsService()) : ViewModel() {

    private val _mealDetail = MutableStateFlow<DetailResponse?>(null)
    val mealDetail: StateFlow<DetailResponse?> get() = _mealDetail

    fun getMealDetail(mealId: String) {
        viewModelScope.launch {
            val response = service.getMealDetail(mealId)
            _mealDetail.value = response
        }
    }
}