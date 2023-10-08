package com.example.mealsapp.meals

import com.example.mealsapp.MealsWebService
import com.example.mealsapp.navigation.response.mealCategoryResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class MeaslService(private val web: MealsWebService = MealsWebService()) {

    fun getMeals(successCallback: (response: mealCategoryResponse?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = web.getMeals()
                withContext(Dispatchers.Main) {
                    successCallback(response)
                }
            } catch (e: HttpException) {
                withContext(Dispatchers.Main) {
                }
            } catch (e: Throwable) {
                withContext(Dispatchers.Main) {
                }
            }
        }
    }
}


