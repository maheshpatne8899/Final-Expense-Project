package com.ExpenseApp1.Project.Service;

import java.util.List;

import com.ExpenseApp1.Project.pojo.Category;

public interface ICategoryService {
	
	public String addCategory(Category category);

	

	public List<Category> getCategoryList();



	public Category getCategoryById(Integer id);

	
	

}
