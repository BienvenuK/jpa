package poe.blablacar.form;



import poe.blablacar.domain.Account;
import poe.blablacar.domain.Ride;

public class BookingCreateForm {
	
	private String caracteristic;
	
	  public String getCaracteristic() {
		return caracteristic;
	}


	public void setCaracteristic(String caracteristic) {
		this.caracteristic = caracteristic;
	}


	private Ride ride;
	  private String lieuArrive;
	  private String lieuDepart;
	  
	  private String jourDepart;
	  private String jourArrive;
	  
	  private String heureDepart;
	  private String heureArrive;
	  
	  public String getJourDepart() {
		return jourDepart;
	}


	public void setJourDepart(String jourDepart) {
		this.jourDepart = jourDepart;
	}


	public String getJourArrive() {
		return jourArrive;
	}


	public void setJourArrive(String jourArrive) {
		this.jourArrive = jourArrive;
	}


	public String getHeureDepart() {
		return heureDepart;
	}


	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}


	public String getHeureArrive() {
		return heureArrive;
	}


	public void setHeureArrive(String heureArrive) {
		this.heureArrive = heureArrive;
	}


	public String getMinuteDepart() {
		return minuteDepart;
	}


	public void setMinuteDepart(String minuteDepart) {
		this.minuteDepart = minuteDepart;
	}


	public String getMinuteArrive() {
		return minuteArrive;
	}


	public void setMinuteArrive(String minuteArrive) {
		this.minuteArrive = minuteArrive;
	}


	private String minuteDepart;
	  private String minuteArrive;
	  

	   
	    public String getLieuArrive() {
		return lieuArrive;
	}


	public void setLieuArrive(String lieuArrive) {
		this.lieuArrive = lieuArrive;
	}


	public String getLieuDepart() {
		return lieuDepart;
	}


	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}


		public Ride getRide() {
		return ride;
	}


	public void setRide(Ride ride) {
		this.ride = ride;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


		private Account  account;

}
