package poe.blablacar.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.blablacar.Service.AccountService;
import poe.blablacar.dao.AccountDao;
import poe.blablacar.domain.Account;
import poe.blablacar.form.AccountCreateForm;


@Controller
@RequestMapping
public class AccountCreateFormBean extends WebMvcConfigurerAdapter{
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountDao accountDao;
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/results").setViewName("results");
	    }
	 
	    @GetMapping("/")
	    public String showForm(AccountCreateForm accountCreateForm) {
	        return "form";
	    }

	  
	    @PostMapping("/")
	    public String checkPersonInfo(@Valid AccountCreateForm accountCreateForm, BindingResult bindingResult, Model model,RedirectAttributes redirectAttributes) {

	        if (bindingResult.hasErrors()) {
	            return "form";
	        }
	        
	        
	        
	        
	        if (accountDao.findAllByEmail(accountCreateForm.getEmail()) != null) {
	            // on a déjà un utilisateur avec ce login
	            model.addAttribute("duplicateLoginError", "Cet utilisateur existe déjà");
	            return "user/signup";
	        }
	        
	        Account account = new Account();
	        DateFormat   formatter = new SimpleDateFormat("yyyy-MM-dd");
	      Date date = new Date();
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
	        redirectAttributes.addAttribute("account", account.getId());
	       accountService.add(account);
	        return "form";
	    }

}
