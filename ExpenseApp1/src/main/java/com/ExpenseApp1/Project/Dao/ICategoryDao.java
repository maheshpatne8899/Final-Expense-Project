package com.ExpenseApp1.Project.Dao;

import java.util.List;

import com.ExpenseApp1.Project.pojo.Category;

public interface ICategoryDao {
	
		
		public String addCategory(Category category);

		

		public List<Category> getCategoryList();



		public Category getCategoryById(Integer id);
		

	}
