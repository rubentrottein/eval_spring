package com.example.PayMe.controller;

import com.example.PayMe.service.DarkTransactionService;
import com.example.PayMe.service.TransactionService;
import com.example.PayMe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DarkTransactionController {


	@Autowired
	UserService userService;
	
	@Autowired
	DarkTransactionService darkTransactionService;

	@Autowired
	TransactionService transactionService;


	@GetMapping("/darktransactions")
	public String getDarkTransactionsPage(Model model) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("transactions", transactionService.getTransactionsListByUserName(userName));
		return "darkTransactionsPage";
	}
	@RequestMapping(value="/doDarkTransaction")
	public String doDarkTransaction(@RequestParam(value = "user") String userName, Model model){

		model.addAttribute("users", userService.getAllUser());
		model.addAttribute("message", darkTransactionService.createDarkTransaction(userName));

		return "darkAdminUsers";
	}
}
