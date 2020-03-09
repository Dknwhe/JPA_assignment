package se.ecutb.cai.JPA_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.cai.JPA_assignment.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findByManyRecipeNameContains (String recipeName);
    List<Recipe> findByAllRecipeIngredientName (String ingredientName);
    List<Recipe> findByAllCategories (String category);
    List<Recipe> findByAllRecipeCategories(List<String> category);
}
