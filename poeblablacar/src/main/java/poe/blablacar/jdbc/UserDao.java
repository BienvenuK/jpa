package poe.blablacar.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import poe.blablacar.aop.Chrono;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserDao {

	 @Autowired
	    JdbcTemplate jdbcTemplate;

	    @Chrono
	    public void batchInsert() {
	        List<String> accounts = new ArrayList<>();
	        List<Object[]> parameters = new ArrayList<Object[]>();
	        for (int i = 0; i < 10000; i++) {
	            parameters.add(new String[]{"email " + i});
	        }
	        jdbcTemplate.batchUpdate("INSERT INTO user(login) VALUES (?)", parameters);
	    }
}
