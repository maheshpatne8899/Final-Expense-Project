package com.ExpenseApp1.Project.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.ExpenseApp1.Project.pojo.Expense;
@Repository
@Transactional
public class ExpenseDao_impl implements IExpenseDao{

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public String addExpense(Expense expense) {
	entityManager.persist(expense);
	return "Expense Added Successfully";
	}

	@Override
	public List<Expense> getExpenseList(Expense expense) {
		String jpql="select e from Expense e ";
		return entityManager.createQuery(jpql,Expense.class).getResultList();
	}
	@Override
	public Expense getExpenseById(Integer id) {
		String jpql="Select e from Expense e where e.expense_id=:eid";
		Expense expense=entityManager.createQuery(jpql,Expense.class).setParameter("eid", id).getSingleResult();
		return expense;
	}

}
