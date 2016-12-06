package controller.profile;
//import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public   class UserProfile {
	private String pets;
	private String smoke;
	private String drink;
	private String Rent_sltn; 
	private String APT_SELECTION;
	private String area ;
	private String gndr ;
	private String clns ;
	private String trsh ;
	private String prty ;
	private String vgn ;
	private String rm ;
	
	public String getRent_sltn() {
		return Rent_sltn;
	}
	public void setRent_sltn(String rent_sltn) {
		Rent_sltn = rent_sltn;
	}
	public String getAPT_SELECTION() {
		return APT_SELECTION;
	}
	public void setAPT_SELECTION(String aPT_SELECTION) {
		APT_SELECTION = aPT_SELECTION;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getGndr() {
		return gndr;
	}
	public void setGndr(String gndr) {
		this.gndr = gndr;
	}
	public String getClns() {
		return clns;
	}
	public void setClns(String clns) {
		this.clns = clns;
	}
	public String getTrsh() {
		return trsh;
	}
	public void setTrsh(String trsh) {
		this.trsh = trsh;
	}
	public String getPrty() {
		return prty;
	}
	public void setPrty(String prty) {
		this.prty = prty;
	}
	public String getVgn() {
		return vgn;
	}
	public void setVgn(String vgn) {
		this.vgn = vgn;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	public String getPets() {
		return pets;
	}
	public void setPets(String pets) {
		this.pets = pets;
	}
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}

}
