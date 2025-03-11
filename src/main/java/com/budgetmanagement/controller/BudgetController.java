package com.budgetmanagement.controller;

import com.budgetmanagement.model.Budget;
import com.budgetmanagement.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {
    @Autowired
    private BudgetService service;

    @GetMapping
    public List<Budget> getAllBudgets() {
        return service.getAllBudgets();
    }

    @GetMapping("/{id}")
    public Budget getBudgetById(@PathVariable Long id) {
        return service.getBudgetById(id);
    }

    @PostMapping
    public Budget createBudget(@RequestBody Budget budget) {
        return service.createBudget(budget);
    }

    @PutMapping("/{id}")
    public Budget updateBudget(@PathVariable Long id, @RequestBody Budget budgetDetails) {
        return service.updateBudget(id, budgetDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable Long id) {
        service.deleteBudget(id);
    }
}
