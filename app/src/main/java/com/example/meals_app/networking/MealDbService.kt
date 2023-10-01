
import retrofit2.http.GET



interface MealDbService {
    @GET("list.php?c=list")
    suspend fun getAllCategories(): CategoryListResponse
}

data class CategoryListResponse(
    val categories: List<Category>
)

data class Category(
    val strCategory: String
)