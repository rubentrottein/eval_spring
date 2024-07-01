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
	int Michiefs = 0;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	public String createDarkTransaction(String userName){
		User darkUser = userService.getUserByName("DarKUseR");
		User user = userService.getUserByName(userName);
		float amount = 100F;

		if((user.getBalance()- amount) >0){
			user.setBalance(user.getBalance()-amount);

			darkUser.setBalance(darkUser.getBalance() + amount);

			userRepository.save(user);
			userRepository.save(darkUser);
			StolenMoney += (int) amount;
			Michiefs++;

			return "Méfait Accompli! (nombre de vols : " + Michiefs + " ), Somme totale : " + StolenMoney;
		} else {
			return "Gourmand, La moulah n'est pas infinie! " + user.getName() + " n'a plus sur son compte que " + user.getBalance();
		}
	}
}
