package poe.blablacar.controller;


import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import poe.blablacar.Service.AccountService;
import poe.blablacar.Service.BookingService;
import poe.blablacar.domain.Account;
import poe.blablacar.domain.Booking;
import poe.blablacar.form.BookingCreateForm;

@Controller
@RequestMapping("/booking")
public class BookingCreateFormBean extends WebMvcConfigurerAdapter {
	
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	AccountService accountService;
	
	
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/results").setViewName("results");
	    }
	 

	    @GetMapping("/")
	    public String showForm(BookingCreateForm bookingCreateForm) {
	        return "form";
	    }
	    
	    

	    @PostMapping("/")
	    public String checkPersonInfo(@Valid BookingCreateForm bookingCreateForm, BindingResult bindingResult) {

	        if (bindingResult.hasErrors()) {
	            return "form";
	        }
	        
	       
	     
		

	        return "redirect:/results";
	    }
	    
	    @GetMapping
	    public String bookARide(@RequestParam(name = "ride") String rideId, @RequestParam(name = "account") String userId, Model model) {
	        if (rideId != null && !rideId.isEmpty()) {
	            Booking booking = bookingService.bookARide(Long.valueOf(userId), Long.valueOf(rideId));
	            model.addAttribute("booking", booking);
//	           Iterable<Account> accounts = accountService.accounts();
//	           model.addAttribute("accounts", accounts);
	        }
	        return "ride/booked";
	      //  return "ride/create";
	    }


}
