package com.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "recipe")
public class Recipe 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_id")
	private int recipeId;
	
	
	@Column(name = "recipe_name")
	@NotNull(message = "Please Enter the Recipe name!!")
	@Size(min = 1, message = "Please Enter the Recipe name!!")
	private String recipeName;
	
	@Column(name = "is_available")
	private String isAvailable;
	
	
	@Column(name = "cost")
	@Min(value = 1, message = "Cost of the recipe cannot be 0")
	private int cost;
	
	public Recipe()
	{
		
	}

	public Recipe(String recipeName, String isAvailable, int cost) {
		this.recipeName = recipeName;
		this.isAvailable = isAvailable;
		this.cost = cost;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Recipe [recipeName=" + recipeName + ", isAvailable=" + isAvailable + ", cost=" + cost + "]";
	}

}
