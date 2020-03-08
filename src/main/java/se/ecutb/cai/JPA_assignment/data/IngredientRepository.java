package se.ecutb.cai.JPA_assignment.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.cai.JPA_assignment.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository <Ingredient, Integer> {

    Optional<Ingredient> findByOneIngredientName(String ingredientName);
    List<Ingredient> findByManyIngredientNameContains(String Name);
}
