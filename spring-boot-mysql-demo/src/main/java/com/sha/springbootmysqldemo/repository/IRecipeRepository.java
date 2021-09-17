package com.sha.springbootmysqldemo.repository;


import com.sha.springbootmysqldemo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IRecipeRepository extends JpaRepository<Recipe, Long>{
	List<Recipe> findByName(String name);
}
