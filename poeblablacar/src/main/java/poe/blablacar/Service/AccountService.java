package poe.blablacar.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.blablacar.dao.AccountDao;
import poe.blablacar.domain.Account;


@Service
public class AccountService {
	
	@Autowired
	AccountDao accountDao;
	
	public void add(Account account) {
		accountDao.save(account);
	}
	
	public Account get(Long idAccount) {
		return  accountDao.findOne(idAccount);
	}
	
	public void edit(Account account) {
		accountDao.save(account);
	}
	
	public void delete(Long idAccount) {
		accountDao.delete(idAccount);
	}
	
	public Iterable<Account> accounts(){
		
		return  accountDao.findAll();
		
	}
	
	public boolean exist(Long idAccount) {
		return accountDao.exists(idAccount);
	}
	
	

}
