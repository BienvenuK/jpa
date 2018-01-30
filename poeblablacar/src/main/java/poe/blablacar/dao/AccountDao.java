package poe.blablacar.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poe.blablacar.domain.Account;




@Repository
public interface AccountDao extends CrudRepository<Account, Long> {
	
	public Account  findAllByEmail(String email);


	
}








