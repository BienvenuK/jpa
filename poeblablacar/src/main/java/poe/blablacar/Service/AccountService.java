package poe.blablacar.Service;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import poe.blablacar.dao.AccountDao;
import poe.blablacar.dao.RideDao;
import poe.blablacar.domain.Account;
import poe.blablacar.domain.Ride;
import org.springframework.security.core.GrantedAuthority;


@Service
public class AccountService {
	
	@Autowired
	AccountDao accountDao;
	@Autowired
	RideService rideService;
	
	@Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	public void add(Account account) {
		accountDao.save(account);
		
		try {
            inMemoryUserDetailsManager.createUser(new org.springframework.security.core.userdetails.User(account.getEmail(), account.getPassword(), new ArrayList<GrantedAuthority>()));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
	
	
	@Transactional
	public void addRide(Long idRide, Long idAccount) {
	Account account = this.get(idAccount);
	Ride ride = rideService.get(idRide);
	account.getProposedRides().add(ride);
	ride.setDriver(account);
	this.add(account);
	}
	
	

}
