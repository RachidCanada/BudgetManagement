package com.budgetmanagement.service;

import com.budgetmanagement.model.Budget;
import com.budgetmanagement.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository repository;

    public List<Budget> getAllBudgets() {
        return repository.findAll();
    }

    public Budget getBudgetById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Budget createBudget(Budget budget) {
        return repository.save(budget);
    }

    public Budget updateBudget(Long id, Budget budgetDetails) {
        Budget budget = repository.findById(id).orElse(null);
        if (budget != null) {
            budget.setName(budgetDetails.getName());
            budget.setCategory(budgetDetails.getCategory());
            budget.setAmount(budgetDetails.getAmount());
            budget.setCreatedAt(budgetDetails.getCreatedAt());
            return repository.save(budget);
        }
        return null;
    }

    public void deleteBudget(Long id) {
        repository.deleteById(id);
    }
}
