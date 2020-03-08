package se.ecutb.cai.JPA_assignment.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.cai.JPA_assignment.entity.Recipe;
import se.ecutb.cai.JPA_assignment.entity.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionRepository extends JpaRepository <RecipeInstruction, String> {

}
