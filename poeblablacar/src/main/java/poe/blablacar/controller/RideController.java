package poe.blablacar.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
import poe.blablacar.aop.Chrono;
import poe.blablacar.dao.AccountDao;
import poe.blablacar.dao.RideDao;
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
	private AccountDao accountDao;
	@Autowired
	private RideService rideService;
	@Autowired
	private RideDao rideDao;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping
	public String showForm(Account account,  RideCreateForm rideCreateForm,  @RequestParam(name = "ride", required = false) String rideId, BindingResult bindingResult , Model model, RedirectAttributes redirectAttributes,Principal principal) {
		if (rideId != null && !rideId.isEmpty()) {
			Ride ride = rideService.get(Long.valueOf(rideId))  ;        
			model.addAttribute("ride", ride);
		}
		System.out.println("LoggedIn account : " + principal.getName());
		Iterable<Account> accounts = accountService.accounts();
		model.addAttribute("accounts", accounts);
		return "ride/accountAddRide";
	}

	@Chrono
	@PostMapping
	public String offerARide(@Valid RideCreateForm rideCreateForm,Principal principal, BindingResult bindingResult , Model model, RedirectAttributes redirectAttributes) {
		
		Account account = accountDao.findAllByEmail(principal.getName());
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return "ride/accountAddRide";
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
		Ride ride = rideService.offerARide(convertedDateMinutePrecision, rideCreateForm.getCaracteristic(), rideCreateForm.getTotalPlaces(), rideCreateForm.getLeftPlaces(), rideCreateForm.getLieuDepart(), rideCreateForm.getLieuArrive(), rideCreateForm.getPrice(), account.getId());
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

	@GetMapping("search")
	public String search(Model model, @RequestParam(name = "search", required = true) String search) {

		Iterable<Ride> rides;
		System.out.println("searching " + search);
		if (search != null && !search.isEmpty()) {
			System.out.println("searching town for " + search);
			rides = rideDao.findAllByLieuArriveLikeIgnoreCaseOrLieuDepartLikeIgnoreCase("%" + search + "%", "%" + search + "%");
		} else {            
			rides = rideService.rides();
		}

		model.addAttribute("rides", rides);
		model.addAttribute("search", search);
		return "ride/list";
	}

	@MessageMapping("newRide")
	@SendTo("/topic/newRide")
	public Ride newRideNotification(Ride ride){
		System.out.println("new ride on air ! " + ride.getId());
		return ride;
	}


}
