package com.example.mealsapp.meals
import androidx.lifecycle.ViewModel
import com.example.mealsapp.navigation.response.mealCategoryResponse

class mealsviewmodel (private val repository: MeaslService = MeaslService()): ViewModel() {
    fun getMeals(successCallback: (response: mealCategoryResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}