package dao;

import java.util.ArrayList;
import java.util.List;

import domain.Account;

public class AccountDao {


	List<Account> accounts = new ArrayList<Account>();

	public  void  addUserDao(Account account) {
		accounts.add(account);
	}


	public List<Account> getUsersListDao(){
		return accounts;
	}



	public Account get(String firstName) {

		for (Account account : accounts) {

			if(accounts.size() == 0) {

				return null;
			}else {
				if(account.getFirstName().equals(firstName)) {

					return account;
				}
			}


		}
		return null;
	}
	public void delete(Account accountDelete){
		for (Account account : accounts) {
		

				if(accounts.size() == 0) {
				}else {
					if(account.getFirstName().equals(accountDelete.getEmail())) {

						accounts.remove(accountDelete);
					}
				}


			}
	}
	
	
}








