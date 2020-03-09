package se.ecutb.cai.JPA_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.cai.JPA_assignment.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, String> {

}
