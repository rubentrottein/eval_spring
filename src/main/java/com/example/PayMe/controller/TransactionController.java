package com.example.PayMe.controller;

import com.example.PayMe.model.User;
import com.example.PayMe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.PayMe.model.Virement;
import com.example.PayMe.service.TransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@Autowired
	UserService userService;
	
	@GetMapping("/transactions")
	public String getTransactionsPage(Model model) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		model.addAttribute("transactions", transactionService.getTransactionsListByUserName(userName));
		return "transactionsPage";
	}
}
