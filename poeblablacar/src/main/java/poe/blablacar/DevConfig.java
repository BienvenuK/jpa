package poe.blablacar;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import poe.blablacar.Service.AccountService;
import poe.blablacar.dao.AccountDao;
import poe.blablacar.dao.RideDao;
import poe.blablacar.domain.Account;
import poe.blablacar.jdbc.UserDao;

@Configuration
@Profile("dev")
public class DevConfig {
	
	

	

	@Autowired
	UserDao userDao;
	
	  @Autowired
	    AccountService accountService;

	    @Autowired
	    RideDao rideDao;

	    @Bean
	    public InitializingBean init() {
	        return () -> {
	            System.out.println("init");
	            Account account = new Account();
	            account.setEmail("jean@gmail.com");
	            account.setPassword("jean");
	            accountService.add(account);

	            account = new Account();
	            account.setEmail("marc@yahoo.fr");
	            account.setPassword("marc");
	            accountService.add(account);

	            userDao.batchInsert();

	        };
	    }

}




