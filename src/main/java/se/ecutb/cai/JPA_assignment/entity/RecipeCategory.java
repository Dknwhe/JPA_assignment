package se.ecutb.cai.JPA_assignment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String categoryName;

    @ManyToMany(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )

    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> recipeList = new ArrayList<>();

    public RecipeCategory(int categoryId, String categoryName, List<Recipe> recipeList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.recipeList = recipeList;
    }

    public RecipeCategory(String categoryName) {
        this(0,categoryName,null);
    }

    RecipeCategory() {}

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public boolean addRecipe(Recipe recipe) {
        if (recipe == null) return false;
        if (recipeList.contains(recipe)) {
            return false;
        }

        recipeList.add(recipe);
        return true;
    }

    public boolean removeRecipe(Recipe recipe) {
        if (recipe == null) return false;
        if (!recipeList.contains(recipe)) return false;

        return recipeList.remove(recipe);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return categoryId == that.categoryId &&
                Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecipeCategory{");
        sb.append("categoryId=").append(categoryId);
        sb.append(", categoryName='").append(categoryName).append('\'');
        sb.append(", recipeList=").append(recipeList);
        sb.append('}');
        return sb.toString();
    }
}
