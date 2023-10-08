package com.example.mealsapp.categories

import com.example.mealsapp.MealsWebService
import com.example.mealsapp.navigation.response.CategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class categories(private val web: MealsWebService = MealsWebService()) {
    fun getCategories(categoryId: String, successCallback: (r: CategoriesResponse?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val r = web.getCategories(categoryId)
                withContext(Dispatchers.Main) {
                    if (r != null) {
                        successCallback(r)
                    }
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