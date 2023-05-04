import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatcanicook.data.RecipeRepository
import com.example.whatcanicook.data.datamodels.Ingredient
import com.example.whatcanicook.data.datamodels.Recipe
import kotlinx.coroutines.launch
import java.util.logging.Filter

class RecipeViewModel(private val repository: RecipeRepository) : ViewModel() {

    // MutableLiveData for holding a list of recipes
    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> = _recipes

    // MutableLiveData for holding a selected recipe
    private val _selectedRecipe = MutableLiveData<Recipe?>()
    val selectedRecipe: MutableLiveData<Recipe?> = _selectedRecipe

    // MutableLiveData for holding a list of available ingredients
    private val _ingredients = MutableLiveData<List<Ingredient>>()
    val ingredients: LiveData<List<Ingredient>> = _ingredients

    // MutableLiveData for holding a list of ingredients the user has added to their shopping list
    private val _shoppingList = MutableLiveData<List<Ingredient>>()
    val shoppingList: LiveData<List<Ingredient>> = _shoppingList

    // MutableLiveData for holding the current search query
    private val _currentQuery = MutableLiveData<String>()
    val currentQuery: LiveData<String> = _currentQuery

    // MutableLiveData for holding the current filters
    private val _currentFilters = MutableLiveData<Filter>()
    val currentFilters: LiveData<Filter> = _currentFilters

    init {
        // Load the list of available ingredients
        loadIngredients()
    }

    fun loadRecipes() {
        viewModelScope.launch {
            // Fetch recipes from the API based on the current query and filters
            val recipes = repository.getRecipes(currentQuery.value ?: "", currentFilters.value ?: Filter())
            _recipes.value = recipes
        }
    }

    fun selectRecipe(recipe: Recipe) {
        _selectedRecipe.value = recipe
    }

    fun clearSelectedRecipe() {
        _selectedRecipe.value = null
    }

    fun addToShoppingList(ingredient: Ingredient) {
        val currentList = _shoppingList.value ?: emptyList()
        _shoppingList.value = currentList + ingredient
    }

    fun removeFromShoppingList(ingredient: Ingredient) {
        val currentList = _shoppingList.value ?: emptyList()
        _shoppingList.value = currentList - ingredient
    }

    fun clearShoppingList() {
        _shoppingList.value = emptyList()
    }

    fun setQuery(query: String) {
        _currentQuery.value = query
    }

    fun setFilters(filters: Filter) {
        _currentFilters.value = filters
    }

    private fun loadIngredients() {
        viewModelScope.launch {
            // Fetch the list of available ingredients from the API
            val ingredients = repository.getIngredients()
            _ingredients.value = ingredients
        }
    }
}
