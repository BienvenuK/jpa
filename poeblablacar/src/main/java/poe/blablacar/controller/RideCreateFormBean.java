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
import poe.blablacar.Service.RideService;
import poe.blablacar.domain.Ride;
import poe.blablacar.form.RideCreateForm;

@Controller
public class RideCreateFormBean extends WebMvcConfigurerAdapter {
	
	@Autowired
	RideService rideService;
	
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
	        
	       
	      
	        Ride ride = new Ride();
	        DateFormat   formatter = new SimpleDateFormat("yyyy-MM-dd");
	        DateFormat   formatter2 = new SimpleDateFormat("hh:mm:ss");
	      Date datedepart = new Date();
	     Date  heureDepart = new Date();
	      Date dateArrive = new Date();
	      Date heureArrive = new Date();
	      
	      //ljkgfsqu
		try {
			datedepart = formatter.parse(rideCreateForm.getStartDate());
			dateArrive = formatter.parse(rideCreateForm.getStartDate());
			heureDepart = formatter2.parse(rideCreateForm.getStartDate());
			heureArrive = formatter2.parse(rideCreateForm.getStartDate());
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      ride.setArrivalDates(dateArrive);
	      ride.setStartDate(datedepart);
	      ride.setCaracteristics(rideCreateForm.getCaracteristic());
	      ride.setLeftPlaces(rideCreateForm.getLeftPlaces());
	      ride.setLocations(rideCreateForm.getLocation());
	      ride.setTotalPlaces(rideCreateForm.getTotalPlaces());
	      
	      rideService.add(ride);
	      
	      

	        return "redirect:/results";
	    }


}
