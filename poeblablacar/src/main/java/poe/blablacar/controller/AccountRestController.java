package poe.blablacar.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.blablacar.Service.AccountService;
import poe.blablacar.dao.AccountDao;
import poe.blablacar.domain.Account;



@RestController
@RequestMapping("/account")
public class AccountRestController {
	
	@Autowired
	AccountService accountService;
	
	
	
	@PostMapping
	public void signup(@RequestBody Account account) {
		accountService.add(account);
	}
	
	@GetMapping("/exist/{id}")
	public boolean exist(@PathVariable("id") Long idAccount) {
		return accountService.exist(idAccount);
	} 
//	
////	@PostMapping
////	public void edit(Account account) {
////		accountService.edit(account);
////	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long idAccount) {
		accountService.delete(idAccount);
		
	}
	
	@GetMapping("/accounts")
	public Iterable<Account> accounts(){
		return accountService.accounts();
	}
	
	
	@GetMapping("/show/{id}")
	public Account get(@PathVariable("id")Long id) {
		
		return accountService.get(id);
	}
	
	
	
	
	
	

}
