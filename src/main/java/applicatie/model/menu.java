package applicatie.model;

public class menu {
	private String gerecht;
	private Float prijs;
	private String beschrijving;
	
	public menu () {
		
	}
	
	public menu(String gerecht, Float prijs, String beschrijving) {
		this.gerecht = gerecht;
		this.prijs = prijs;
		this.beschrijving = beschrijving;
	}

	public String getGerecht() {
		return gerecht;
	}

	public void setGerecht(String gerecht) {
		this.gerecht = gerecht;
	}

	public Float getPrijs() {
		return prijs;
	}

	public void setPrijs(Float prijs) {
		this.prijs = prijs;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
}
