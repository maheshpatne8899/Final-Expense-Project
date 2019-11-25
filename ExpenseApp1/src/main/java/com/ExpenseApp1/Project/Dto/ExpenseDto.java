package com.ExpenseApp1.Project.Dto;

import java.util.Date;

public class ExpenseDto {
	private int expense_id;
	private String expense_type;
	private double expense_amount;
	private Date expensedate;
	public ExpenseDto() {
		super();
	}
	public ExpenseDto(int expense_id, String expense_type, double expense_amount, Date expensedate) {
		super();
		this.expense_id = expense_id;
		this.expense_type = expense_type;
		this.expense_amount = expense_amount;
		this.expensedate = expensedate;
	}
	public int getExpense_id() {
		return expense_id;
	}
	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}
	public String getExpense_type() {
		return expense_type;
	}
	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}
	public double getExpense_amount() {
		return expense_amount;
	}
	public void setExpense_amount(double expense_amount) {
		this.expense_amount = expense_amount;
	}
	public Date getExpensedate() {
		return expensedate;
	}
	public void setExpensedate(Date expensedate) {
		this.expensedate = expensedate;
	}

}
