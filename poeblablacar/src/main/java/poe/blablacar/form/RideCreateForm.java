package poe.blablacar.form;





import poe.blablacar.domain.Account;
import poe.blablacar.domain.Ride;

public class RideCreateForm {
	private Long accountId;
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Ride getRide() {
		return ride;
	}
	int totalPlaces;
	int leftPlaces;
	private String lieuArrive;
	  private String lieuDepart;
	  
	  private String jourDepart;
	  private String jourArrive;
	  
	  private int heureDepart;
	  private int heureArrive;
	  
	  private int minuteD;
	  private int minuteA;
	  private Double price;
	 private String caracteristic;
	
	  
	 public String getCaracteristic() {
		return caracteristic;
	}
	public void setCaracteristic(String caracteristic) {
		this.caracteristic = caracteristic;
	}
	public int getTotalPlaces() {
		return totalPlaces;
	}
	public void setTotalPlaces(int totalPlaces) {
		this.totalPlaces = totalPlaces;
	}
	public int getLeftPlaces() {
		return leftPlaces;
	}
	public void setLeftPlaces(int leftPlaces) {
		this.leftPlaces = leftPlaces;
	}
	private Ride ride;
	
	 public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void setRide(Ride ride) {
		this.ride = ride;
	}
	
	
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
	public int getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(int heureDepart) {
		this.heureDepart = heureDepart;
	}
	public int getHeureArrive() {
		return heureArrive;
	}
	public void setHeureArrive(int heureArrive) {
		this.heureArrive = heureArrive;
	}

	public int getMinuteD() {
		return minuteD;
	}
	public void setMinuteD(int minuteD) {
		this.minuteD = minuteD;
	}
	public int getMinuteA() {
		return minuteA;
	}
	public void setMinuteA(int minuteA) {
		this.minuteA = minuteA;
	}
	

}
