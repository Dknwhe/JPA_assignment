package se.ecutb.cai.JPA_assignment.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.cai.JPA_assignment.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends JpaRepository <RecipeIngredient, String> {

}
