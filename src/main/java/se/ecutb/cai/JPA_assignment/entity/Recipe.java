package se.ecutb.cai.JPA_assignment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;

    @OneToMany(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "recipe"
    )
    private List<RecipeIngredient> recipeIngredientList = new ArrayList<>();

    @OneToOne(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )

    @JoinColumn(name = "instruction_id")
    private RecipeInstruction recipeInstruction;

    @ManyToMany(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )

    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id")
    )
    private List<RecipeCategory> categoryList = new ArrayList<>();

    public Recipe(int recipeId, String recipeName, RecipeInstruction recipeInstruction) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeInstruction = recipeInstruction;

    }

    public Recipe(String recipeName, RecipeInstruction recipeInstruction) {
        this(0,recipeName,recipeInstruction);
    }

    public Recipe(String recipeName) {
        this(0,recipeName,null);
    }

    Recipe() {}

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredientList() {
        return recipeIngredientList;
    }

    public void setRecipeIngredientList(List<RecipeIngredient> recipeIngredientList) {
        this.recipeIngredientList = recipeIngredientList;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public List<RecipeCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<RecipeCategory> categoryList) {
        this.categoryList = categoryList;
    }

    public boolean addRecipeIngredient(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) return false;
        if (recipeIngredient.getRecipe() != null) return false;
        if (recipeIngredientList.contains(recipeIngredient)) return false;
        recipeIngredient.setRecipe(this);
        return recipeIngredientList.add(recipeIngredient);
    }

    public boolean removeRecipeIngredient(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) return false;
        if (recipeIngredient.getRecipe() != this) return false;
        recipeIngredient.setRecipe(null);
        return recipeIngredientList.remove(recipeIngredient);
    }

    public boolean addCategory(RecipeCategory recipeCategory) {
        if (recipeCategory == null) return false;
        if (categoryList.contains(recipeCategory)) return false;
        return categoryList.add(recipeCategory);
    }

    public boolean removeCategory(RecipeCategory recipeCategory) {
        if (recipeCategory == null) return false;
        if (!categoryList.contains(recipeCategory)) return false;
        return categoryList.remove(recipeCategory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId &&
                Objects.equals(recipeName, recipe.recipeName) &&
                Objects.equals(recipeInstruction, recipe.recipeInstruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName, recipeInstruction);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Recipe{");
        sb.append("recipeId=").append(recipeId);
        sb.append(", recipeName='").append(recipeName).append('\'');
        sb.append(", recipeIngredientList=").append(recipeIngredientList);
        sb.append(", recipeInstruction=").append(recipeInstruction);
        sb.append(", categoryList=").append(categoryList);
        sb.append('}');
        return sb.toString();
    }
}
