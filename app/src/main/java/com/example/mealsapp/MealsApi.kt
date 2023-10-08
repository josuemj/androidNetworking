package com.example.mealsapp
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.mealsapp.navigation.response.CategoriesResponse
import com.example.mealsapp.navigation.response.DetailResponse
import com.example.mealsapp.navigation.response.mealCategoryResponse

interface MealsApi {
    @GET("categories.php")
    suspend fun getMeals(): mealCategoryResponse

    @GET("filter.php")
    suspend fun getMealsInCategory(@Query("c") categoryId: String): CategoriesResponse

    @GET("lookup.php")
    suspend fun getMealDetail(@Query("i") mealId: String): DetailResponse?
}
