package applicatie.model;

public class klant {
	
	private int klant_Id;
	private String naam;
	private String wachtwoord;
	private String email;
	
	public klant() {
		
	}
	
	public klant(int klant_Id, String naam, String wachtwoord, String email) {
		this.klant_Id = klant_Id;
		this.naam = naam;
		this.wachtwoord = wachtwoord;
		this.email = email;
	}

	public int getKlant_Id() {
		return klant_Id;
	}

	public void setKlant_Id(int klant_Id) {
		this.klant_Id = klant_Id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
