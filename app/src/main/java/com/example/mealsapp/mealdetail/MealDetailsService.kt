package com.example.mealsapp.mealdetail
import com.example.mealsapp.MealsWebService
import com.example.mealsapp.navigation.response.DetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealDetailsService(private val web: MealsWebService = MealsWebService()) {

    suspend fun getMealDetail(mealId: String): DetailResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = web.getDetail(mealId)
                response
            } catch (e: Exception) {
                null
            }
        }
    }

}