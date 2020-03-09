package se.ecutb.cai.JPA_assignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.ecutb.cai.JPA_assignment.entity.*;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecipeRepTest {
//I Repositories klasser ska allt vara testat som ni skrivit

    @Autowired
    RecipeRepository testObject;
    @Autowired
    TestEntityManager em;

    @BeforeEach
    void setUp() {

        Ingredient ingredient = em.persist(new Ingredient("Test1"));
        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient,1, Measurement.KG);
        Recipe recipe = new Recipe("Test2");
        recipe.addRecipeIngredient(recipeIngredient);
        RecipeCategory recipeCategory = new RecipeCategory("Test3");
        recipe.addCategory(recipeCategory);
        recipe.setRecipeInstruction(new RecipeInstruction("Test4"));
        testObject.save(recipe);
    }

    @Test
    ////Hitta flera recept vars receptnamn innehåller en viss String
    public void given_many_recipeName_return_list_size() {
        String name = "test";
        List<Recipe> result = testObject.findByManyRecipeNameContains(name);
        assertEquals(1,result.size());
    }

    @Test
    //Hitta alla recept som innehåller ett visst ingrediensnamn
    public void given_all_recipeIngredient_return_list_size() {
        List<Recipe> result = testObject.findByAllRecipeIngredientName("Test1");
        assertEquals(1,result.size());
    }

    @Test
    //Hitta alla recept som tillhör en viss receptkategori
    public void given_all_recipeCategory_return_list_size() {
        List<Recipe> result = testObject.findByAllCategories("Test3");
        assertEquals(1,result.size());
    }

    @Test
    //Hitta alla recept som har en eller flera träffar från en samling kategorier
    public void given_all_and_many_recipeCategories_return_list_size() {
        List<Recipe> result = testObject.findByAllRecipeCategories(Arrays.asList("Test"));
        assertEquals(1,result.size());
    }
}
