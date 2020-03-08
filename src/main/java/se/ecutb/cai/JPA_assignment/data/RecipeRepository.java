package se.ecutb.cai.JPA_assignment.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.cai.JPA_assignment.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository <Recipe, Integer> {

    List<Recipe> findByManyRecipeNameContains (String recipeName);
    List<Recipe> findByAllRecipeIngredientName (String ingredientName);
    List<Recipe> findByAllCategories (String category);
    List<Recipe> findByAllRecipeCategories(List<String> category);
}
