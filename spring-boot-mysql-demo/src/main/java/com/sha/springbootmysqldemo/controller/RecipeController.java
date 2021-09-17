package com.sha.springbootmysqldemo.controller;

import com.sha.springbootmysqldemo.exception.ResourceNotFoundException;
import com.sha.springbootmysqldemo.model.Recipe;
import com.sha.springbootmysqldemo.repository.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RecipeController {

  @Autowired
  private IRecipeRepository recipeRepository;

  /**
   * Get all recipes list.
   *
   * @return the list
   */
  @GetMapping("/recipes")
  public List<Recipe> getAllRecipes() {
    return recipeRepository.findAll();
  }

  /**
   * Gets recipes by name.
   *
   * @param name
   * @return the recipes by name
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/recipes/{id}")
  public ResponseEntity<Recipe> getRecipeById(@PathVariable(value = "id") Long id)
      throws ResourceNotFoundException {
    Recipe recipe =
        recipeRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recipe not found on :: " + id));
    return ResponseEntity.ok().body(recipe);
  }

  /**
   * Create recipe recipe.
   *
   * @param recipe the recipe
   * @return the recipe
   */
  @PostMapping("/create")
  public Recipe createRecipe(@RequestBody Recipe recipe) {
    return recipeRepository.save(recipe);
  }

  /**
   * Update recipe response entity.
   *
   * @param recipeId the id
   * @param recipeDetails the recipe details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/recipes/{id}")
  public ResponseEntity<Recipe> updateRecipe(
      @PathVariable(value = "id") Long id, @RequestBody Recipe recipeDetails)
      throws ResourceNotFoundException {

    Recipe recipe =
        recipeRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recipe not found on :: " + id));

    recipe.setInstructions(recipeDetails.getInstructions());
    recipe.setIngredients(recipeDetails.getIngredients());
    recipe.setServes(recipeDetails.getServes());
    recipe.setIsVeg(recipeDetails.getIsVeg());
    final Recipe updatedRecipe = recipeRepository.save(recipe);
    return ResponseEntity.ok(updatedRecipe);
  }

  /**
   * Delete recipe map.
   *
   * @param recipeId the recipe id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/recipe/{id}")
  public Map<String, Boolean> deleteRecipe(@PathVariable(value = "id") Long id) throws Exception {
    Recipe recipe =
        recipeRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recipe not found on :: " + id));

    recipeRepository.delete(recipe);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}