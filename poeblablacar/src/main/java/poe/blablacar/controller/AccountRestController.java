package poe.blablacar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import poe.blablacar.dto.AccountDto;





@RestController
@RequestMapping("/account")
public class AccountRestController {
	
	@Autowired
	AccountService accountService;
	
//	@Autowired
//	AccountDto accountDto;
	
	
	
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
	public Iterable<AccountDto> accounts(){
		
		List<AccountDto> accounts = new ArrayList<>();
		
		
		for (Account account : accountService.accounts()) {
			
			AccountDto accountDto = AccountDto.buildFrom(account);
			accounts.add(accountDto);
			 
			
		}
		return accounts;
	
	}
	
	
	@GetMapping("/show/{id}")
	public AccountDto get(@PathVariable("id")Long id) {
		
		Account account = accountService.get(id);
		AccountDto accountDto = AccountDto.buildFrom(account);
		 return accountDto;
	}
	
	
	
	@PostMapping("/{idAccount}/{idRide}")
	public void addRide(@PathVariable("idAccount" ) Long idAccount , @PathVariable("idRide") Long idRide) {
		accountService.addRide(idRide, idAccount);
	}
	
	
	
	

}
