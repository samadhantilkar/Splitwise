package com.example.Splitwise.controller;

import com.example.Splitwise.services.ExpenseServices;
import org.springframework.stereotype.Controller;

@Controller
public class ExpenseController {
    ExpenseServices expenseServices;
    ExpenseController(ExpenseServices expenseServices){
        this.expenseServices=expenseServices;
    }


}
