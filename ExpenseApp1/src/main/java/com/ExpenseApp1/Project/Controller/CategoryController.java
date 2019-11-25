package com.ExpenseApp1.Project.Controller;


import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseApp1.Project.Dto.CategoryDto;
import com.ExpenseApp1.Project.Exception.CategoryNotFoundException;
import com.ExpenseApp1.Project.Repository.CategoryRepository;
import com.ExpenseApp1.Project.Service.ICategoryService;
import com.ExpenseApp1.Project.pojo.Category;


@RestController
@RequestMapping("/category")
public class CategoryController

{	
	@Autowired
	ICategoryService categoryService;
	@Autowired
	private CategoryRepository categoryRepository;
	
	/* ADD CATEGORY */
	@PostMapping("/addcategory")
	public Category addCategory(@RequestBody CategoryDto categorydto)
	{
		Category cat=new Category();
		cat.setCategoryId(categorydto.getCategoryId());
		cat.setCategoryName(categorydto.getCategoryName());
		cat.setCategoryDesc(categorydto.getCategoryDesc());
		return categoryRepository.save(cat);
	}
	

	/* GET CATEGORY BY ID */
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer id)
	{
		try
		{
		Category cat=categoryService.getCategoryById(id);
		return new ResponseEntity<Category>(cat,HttpStatus.OK);
		}
		catch(Exception e) 
		{
			throw new CategoryNotFoundException(""); 
		}
		
	}
	

	/* UPDATE CATEGORY */
    @PutMapping("/category/{id}")	
	ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category)	{
		Category result=categoryRepository.save(category);
	return ResponseEntity.ok().body(result);
		}
	
    

	/*  CATEGORY LIST */
	@GetMapping("/categories")	
 public ResponseEntity<List<Category>>categories()
	 {
		
		return ResponseEntity.ok().body(categoryRepository.findAll());
	 
      }

	/* DELETE CATEGORY */
    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Integer id)
   {
	     categoryRepository.deleteById(id);
	     return ResponseEntity.ok().build();
    }
}