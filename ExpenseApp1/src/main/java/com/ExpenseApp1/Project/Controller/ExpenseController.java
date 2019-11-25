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

import com.ExpenseApp1.Project.Dto.ExpenseDto;
import com.ExpenseApp1.Project.Exception.ExpenseNotFoundException;
import com.ExpenseApp1.Project.Repository.ExpenseRepository;
import com.ExpenseApp1.Project.Service.IExpenseService;

import com.ExpenseApp1.Project.pojo.Expense;


@RestController
@RequestMapping("/expense")
public class ExpenseController {
	@Autowired
	IExpenseService expenseService;
	@Autowired
	private ExpenseRepository expenseRepository;
	

	/* ADD EXPENSE */
	@PostMapping("/addexpense")
	public Expense addExpense(@RequestBody ExpenseDto expensedto)
	{
		
		Expense exp=new Expense();
		exp.setExpense_id(expensedto.getExpense_id());
		exp.setExpense_type(expensedto.getExpense_type());
		
		exp.setExpense_amount(expensedto.getExpense_amount());
		exp.setExpensedate(expensedto.getExpensedate());
		
		return expenseRepository.save(exp);
	
	}
	
	

	/* EXPENSE LIST*/
	@GetMapping("/expenselist")	
	 public ResponseEntity<List<Expense>>getExpenseList()
		 {
			
			return ResponseEntity.ok().body(expenseRepository.findAll());
	     }
	
	
	/* GET EXPENSE BY ID */
	@GetMapping("/expenselist/{id}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable Integer id)
	{
		try
		{
			Expense exp=expenseService.getExpenseById(id);
		return new ResponseEntity<Expense>(exp,HttpStatus.OK);
		}
		catch(Exception e) 
		{
			throw new ExpenseNotFoundException(""); 
		}
		
	}
	
	

	/* UPDATE EXPENSE */
	  @PutMapping("/expenselist/{id}")	
		ResponseEntity<Expense> updateExpense(@Valid @RequestBody Expense expense)	{
			Expense result=expenseRepository.save(expense);
		return ResponseEntity.ok().body(result);
			}
		
	  

		/* DELETE EXPENSE */
	  @DeleteMapping("/expense/{id}")
	  ResponseEntity<?> deleteCategory(@PathVariable Integer id)
	  {
	  	expenseRepository.deleteById(id);
	  	return ResponseEntity.ok().build();
	  }

}
