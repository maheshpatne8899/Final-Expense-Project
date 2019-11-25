package com.ExpenseApp1.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ExpenseApp1.Project.pojo.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
