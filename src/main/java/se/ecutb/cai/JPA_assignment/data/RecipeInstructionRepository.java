package se.ecutb.cai.JPA_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.cai.JPA_assignment.entity.RecipeInstruction;


public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, String> {

}
