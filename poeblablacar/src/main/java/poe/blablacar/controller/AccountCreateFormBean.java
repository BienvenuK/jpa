package poe.blablacar.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import poe.blablacar.Service.AccountService;
import poe.blablacar.domain.Account;
import poe.blablacar.form.AccountCreateForm;


@Controller
public class AccountCreateFormBean extends WebMvcConfigurerAdapter{
	
	@Autowired
	private AccountService accountService;
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/results").setViewName("results");
	    }
	 

	    @GetMapping("/")
	    public String showForm(AccountCreateForm accountCreateForm) {
	        return "form";
	    }

	    @PostMapping("/")
	    public String checkPersonInfo(@Valid AccountCreateForm accountCreateForm, BindingResult bindingResult) {

	        if (bindingResult.hasErrors()) {
	            return "form";
	        }
	        
	       
	      
	        Account account = new Account();
	        DateFormat   formatter = new SimpleDateFormat("yyyy-MM-dd");
	      Date date = new Date();
	      
	      //ljkgfsqu
		try {
			date = formatter.parse(accountCreateForm.getBirthDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       account.setBirthDate(date);
	       
	       account.setConfirmed(accountCreateForm.isConfirmed());
	       account.setEmail(accountCreateForm.getEmail());
	       account.setPassword(accountCreateForm.getPassword());
	       account.setLastName(accountCreateForm.getLastName());
	       account.setRating(accountCreateForm.getRating());
	       account.setFirstName(accountCreateForm.getLastName());
	       accountService.add(account);

	        return "redirect:/results";
	    }

}
