 package com.ExpenseApp1.Project.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.ExpenseApp1.Project.pojo.Category;

@Repository
@Transactional
public class CategoryDao_impl implements ICategoryDao
{
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public String addCategory(Category category)
	{
		 entityManager.persist(category);
		 return "Category Added";
		
	}
	@Override
	public List<Category> getCategoryList() {
	String jpql="select c from Category c  ";
	return entityManager.createQuery(jpql,Category.class).getResultList(); 
	}
	@Override
	public Category getCategoryById(Integer id) {
		String jpql="Select c from Category c where c.categoryId=:id";
		Category category=entityManager.createQuery(jpql,Category.class).setParameter("id", id).getSingleResult();
		return category;
	}

}
