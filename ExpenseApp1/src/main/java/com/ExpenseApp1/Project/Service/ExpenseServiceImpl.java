package com.ExpenseApp1.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseApp1.Project.Dao.IExpenseDao;
import com.ExpenseApp1.Project.Exception.CategoryNotFoundException;
import com.ExpenseApp1.Project.pojo.Expense;

@Service
public class ExpenseServiceImpl implements IExpenseService
{
	@Autowired
	IExpenseDao expenseDao;

	@Override
	public String addExpense(Expense expense) {
		
		return expenseDao.addExpense(expense);
	}



	@Override
	public List<Expense> getExpenseList(Expense expense) {
		
		return expenseDao.getExpenseList(expense);
	}

	@Override
	public Expense getExpenseById(Integer id) {
	
		Expense exp=expenseDao.getExpenseById(id);
		if(exp==null)
		{
			throw new CategoryNotFoundException("msg");
		}
		return expenseDao.getExpenseById(id);	}

}
