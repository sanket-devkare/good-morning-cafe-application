package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.controller.AdminController;
import com.hotel.entity.Recipe;

@Repository
public class HotelDAOImpl implements HotelDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger log = Logger.getLogger(AdminController.class.getName());
	
	@Transactional
	@Override
	public List<Recipe> getAvailabeRecipes() 
	{
		//System.out.println("Inside DAO....");
		Session session = sessionFactory.getCurrentSession();
		List<Recipe> recipeList = session.createQuery("from Recipe where isAvailable = 'true'").list();

		return recipeList;
	}
	
	@Transactional
	@Override
	public List<Recipe> getAllRecipes() 
	{
		//System.out.println("Inside DAO....");
		Session session = sessionFactory.getCurrentSession();
		List<Recipe> recipeList = session.createQuery("from Recipe").list();

		
		return recipeList;
	}

	@Transactional
	@Override
	public int getRecipeCostForTheGivenRecipe(String recipe) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Recipe where recipeName = :recipeNameParameter");
		query.setParameter("recipeNameParameter", recipe);
		
		Object object = query.getSingleResult();
		Recipe recipeObject = (Recipe)object;
		int recipeCost = recipeObject.getCost();
		
		return recipeCost;
	}

	@Transactional
	@Override
	public void addRecipeToDB(Recipe recipe) {
		log.info("Adding a new Recipe :" + recipe);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(recipe);
		log.info("Recipe saved with recipeId: " + recipe.getRecipeId());		
	}

	@Transactional
	@Override
	public Recipe getRecipeById(int recipeId) {
		
		log.info("Getting Recipe based on recipeId: " + recipeId);
		Session session = sessionFactory.getCurrentSession();
		Recipe recipe = session.get(Recipe.class, recipeId);
		log.info("Acquired the required recipe: " + recipe);
		
		return recipe;
	}

	@Transactional
	@Override
	public void deleteRecipeById(int recipeId) {
		
		log.info("Getting Recipe for deleting based on recipeId: " + recipeId);
		Session session = sessionFactory.getCurrentSession();
		
		Recipe recipe = session.get(Recipe.class, recipeId);
		
		if(recipe != null)
		{
			log.info("Acquired the required recipe: " + recipe);
			session.delete(recipe);
			log.info("Recipe Deleted!!!");
		}
		else
		{
			log.info("The required recipe not present in Database");
		}

	}

}
