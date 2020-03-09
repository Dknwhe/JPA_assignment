package se.ecutb.cai.JPA_assignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import se.ecutb.cai.JPA_assignment.entity.Ingredient;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class IngredientRepTest {
//I Repositories klasser ska allt vara testat som ni skrivit


    @Autowired
    private IngredientRepository testObject;
    @Autowired
    private TestEntityManager em;

    private List<Ingredient> data() {
        return Arrays.asList(
                new Ingredient("fruit"),
                new Ingredient("fruit2")
        );
    }

    private List<Ingredient> testIngredient;

    @BeforeEach
    void setUp() {
        testIngredient = (List<Ingredient>) testObject.saveAll(data());
        em.flush();
    }

    @Test
    public void find_ingredient_name_test() {
        //Hitta en ingrediens med specifikt ingrediensnamn.
        String name = "fruit";
        Optional<Ingredient> result = testObject.findByOneIngredientName(name);
        assertTrue(result.isPresent());

    }

    @Test
    public void give_name_return_list_size_2() {
        //Hitta flera ingredienser vars ingrediensnamn innehåller en viss String.
        String name = "fru";
        List<Ingredient> result = testObject.findByManyIngredientNameContains(name);
        assertEquals(2,result.size());
    }

}
