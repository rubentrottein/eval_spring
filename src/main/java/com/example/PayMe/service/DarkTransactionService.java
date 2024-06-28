package com.example.PayMe.service;

import com.example.PayMe.model.Transaction;
import com.example.PayMe.model.User;
import com.example.PayMe.repository.TransactionRepository;
import com.example.PayMe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DarkTransactionService {
	int StolenMoney = 0;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	public String createDarkTransaction(String userName){
		User darkUser = userService.getUserByName("DarKUseR");
		User user = userService.getUserByName(userName);
		user.setBalance(user.getBalance()-100);

		darkUser.setBalance(darkUser.getBalance() + 100);
		user.setBalance(user.getBalance()-100);
		userRepository.save(user);
		userRepository.save(darkUser);
		StolenMoney += 100;

		return "Méfait Accompli! Somme totale : " + StolenMoney;
	}
}
