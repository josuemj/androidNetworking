package com.example.mealsapp.categories
import androidx.lifecycle.ViewModel
import com.example.mealsapp.navigation.response.CategoriesResponse
class categoriesviewmodel(private val repository: categories = categories()): ViewModel() {
    fun getCategory(categoryId: String, successCallback: (response: CategoriesResponse?) -> Unit) {
        repository.getCategories(categoryId) { response ->
            successCallback(response)
        }
    }
}