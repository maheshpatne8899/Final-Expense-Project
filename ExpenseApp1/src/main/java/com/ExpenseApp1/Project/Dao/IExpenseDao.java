package com.ExpenseApp1.Project.Dao;

import java.util.List;

import com.ExpenseApp1.Project.pojo.Expense;

public interface IExpenseDao {
	
	
	String addExpense(Expense expense);

	

	List<Expense> getExpenseList(Expense expense);

	Expense getExpenseById(Integer id);

}
