package poe.blablacar.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.blablacar.Service.AccountService;
import poe.blablacar.Service.RideService;
import poe.blablacar.domain.Account;
import poe.blablacar.domain.Ride;
import poe.blablacar.form.RideCreateForm;
import poe.blablacar.utils.DateUtil;

@RequestMapping("/ride")
@Controller
public class RideController extends WebMvcConfigurerAdapter{

	

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RideService rideService;
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/results").setViewName("results");
	    }
	 
	    @GetMapping
	    public String showForm(Account account,  RideCreateForm rideCreateForm,  @RequestParam(name = "ride", required = false) String rideId, BindingResult bindingResult , Model model, RedirectAttributes redirectAttributes) {
	    	  if (rideId != null && !rideId.isEmpty()) {
	              Ride ride = rideService.get(Long.valueOf(rideId))  ;        
	              model.addAttribute("ride", ride);
	          }
	    	  
	    	  Iterable<Account> accounts = accountService.accounts();
	          model.addAttribute("accounts", accounts);
	          return "ride/accountAddRide";

	    }

	    @PostMapping
	    public String offerARide(@Valid RideCreateForm rideCreateForm, BindingResult bindingResult , Model model, RedirectAttributes redirectAttributes) {

	        if (bindingResult.hasErrors()) {
	        	 System.out.println(bindingResult.getAllErrors());
	             return "ride/accountAddRide";
	        }
	        //jkhg
	      
	        DateFormat   formatter = new SimpleDateFormat("yyyy-MM-dd");
		      Date date = new Date();
			try {
				date = formatter.parse(rideCreateForm.getJourDepart());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        Date convertedDateMinutePrecision = DateUtil.convert(date, rideCreateForm.getHeureDepart(), rideCreateForm.getMinuteD());
	        
	       Ride ride = rideService.offerARide(convertedDateMinutePrecision, rideCreateForm.getCaracteristic(), rideCreateForm.getTotalPlaces(), rideCreateForm.getLeftPlaces(), rideCreateForm.getLieuDepart(), rideCreateForm.getLieuArrive(), rideCreateForm.getPrice(), rideCreateForm.getAccountId());
	      
	    System.out.println(rideCreateForm.getLieuArrive());
	    
	        redirectAttributes.addAttribute("ride", ride.getId());
	        return "redirect:/ride";
	    }
	    
	    
	    @GetMapping("/list")
	    public String list(Model model) {
	       Iterable<Ride>  rides = rideService.rides();

	        model.addAttribute("rides", rides);
	        return "ride/list";
	    }

	  
}
