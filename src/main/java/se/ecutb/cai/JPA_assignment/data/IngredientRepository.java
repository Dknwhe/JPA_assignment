package se.ecutb.cai.JPA_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.cai.JPA_assignment.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    Optional<Ingredient> findByOneIngredientName(String ingredientName);
    List<Ingredient> findByManyIngredientNameContains(String ingredientName);
}
