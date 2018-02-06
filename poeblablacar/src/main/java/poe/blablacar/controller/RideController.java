package poe.blablacar.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import poe.blablacar.Service.AccountService;
import poe.blablacar.Service.RideService;
import poe.blablacar.domain.Ride;
import poe.blablacar.form.AccountCreateForm;
import poe.blablacar.form.RideCreateForm;
import poe.blablacar.utils.DateUtil;

public class RideController extends WebMvcConfigurerAdapter{

	

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RideService rideService;
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/results").setViewName("results");
	    }
	 
	    @GetMapping("/")
	    public String showForm(RideCreateForm rideCreateForm) {
	        return "form";
	    }

	    @PostMapping("/")
	    public String checkPersonInfo(@Valid RideCreateForm rideCreateForm, BindingResult bindingResult) {

	        if (bindingResult.hasErrors()) {
	            return "form";
	        }
	        
	        if (bindingResult.hasErrors()) {
	            return "offerARide";
	        }
	        DateFormat   formatter = new SimpleDateFormat("yyyy-MM-dd");
		      Date date = new Date();
			try {
				date = formatter.parse(rideCreateForm.getJourDepart());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Date convertedDateMinutePrecision = DateUtil.convert(date, rideCreateForm.getHeureDepart(), rideCreateForm.getMinuteD());
	        
	        rideService.offerARide(convertedDateMinutePrecision, rideCreateForm.getCaracteristic(), rideCreateForm.getTotalPlaces(), rideCreateForm.getLeftPlaces(), rideCreateForm.getLieuDepart(), rideCreateForm.getLieuArrive(), rideCreateForm.getPrice(), rideCreateForm.getAccountId());
	      
	        model.addAttribute("message", "Votre trajet a bien été pris en compte.");
	        return "offerARide";
	    }
	    
	    
	        Ride ride = new Ride();
	       String jour =  rideCreateForm.getJourDepart();
	       String jourarrive = rideCreateForm.getJourArrive();
	       int heureA = rideCreateForm.getHeureArrive();
	       int heureD = rideCreateForm.getHeureDepart();
	       int minuteD = rideCreateForm.getMinuteD();
	       int minuteA = rideCreateForm.getMinuteA();
	       
	       
	       
	       
	   ride.setLieuDepart(rideCreateForm.getLieuDepart());
	   ride.setLieuArrive(rideCreateForm.getJourArrive());
	   ride.setLeftPlaces(rideCreateForm.getLeftPlaces());
	   ride.setTotalPlaces(ride.getTotalPlaces());
	   ride.setPrice(rideCreateForm.getPrice());
	   ride.setCaracteristic(rideCreateForm.getCaracteristic());
	   
	   
	 
		
		
		  
		 
	    
	       

	        return "redirect:/results";
	    }
}
