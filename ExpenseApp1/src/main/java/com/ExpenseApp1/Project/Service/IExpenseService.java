package com.ExpenseApp1.Project.Service;

import java.util.List;

import com.ExpenseApp1.Project.pojo.Expense;

public interface IExpenseService {

public	String addExpense(Expense expense);



public List<Expense> getExpenseList(Expense expense);

public Expense getExpenseById(Integer id);


}
