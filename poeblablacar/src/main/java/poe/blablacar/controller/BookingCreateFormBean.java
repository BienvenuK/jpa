//package poe.blablacar.controller;
//
//
//import javax.validation.Valid;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import poe.blablacar.form.BookingCreateForm;
//
//@Controller
//public class BookingCreateFormBean extends WebMvcConfigurerAdapter {
//	
//	
//	
//	
//	
//	
//	 @Override
//	    public void addViewControllers(ViewControllerRegistry registry) {
//	        registry.addViewController("/results").setViewName("results");
//	    }
//	 
//
//	    @GetMapping("/")
//	    public String showForm(BookingCreateForm bookingCreateForm) {
//	        return "form";
//	    }
//	    
//	    
//
//	    @PostMapping("/")
//	    public String checkPersonInfo(@Valid BookingCreateForm bookingCreateForm, BindingResult bindingResult) {
//
//	        if (bindingResult.hasErrors()) {
//	            return "form";
//	        }
//	        
//	       
//	     
//		
//
//	        return "redirect:/results";
//	    }
//
//
//}