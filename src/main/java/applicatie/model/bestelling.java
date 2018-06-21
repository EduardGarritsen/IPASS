package applicatie.model;

public class bestelling {
	
	private int bestelling_ID;
	private int tafel;
	private String gerecht;
	private double prijs;
	private String status;
	private int klant_Id;
	private klant Klant;
	
	public bestelling() {
		
	}

	public bestelling(int bestelling_ID, int tafel, String gerecht, double prijs, String status, int klant_Id) {
		this.bestelling_ID = bestelling_ID;
		this.tafel = tafel;
		this.gerecht = gerecht;
		this.prijs = prijs;
		this.status = status;
		this.klant_Id = klant_Id;
	}

	public int getBestelling_ID() {
		return bestelling_ID;
	}

	public void setBestelling_ID(int bestelling_ID) {
		this.bestelling_ID = bestelling_ID;
	}

	public int getTafel() {
		return tafel;
	}

	public void setTafel(int tafel) {
		this.tafel = tafel;
	}

	public String getGerecht() {
		return gerecht;
	}

	public void setGerecht(String gerecht) {
		this.gerecht = gerecht;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getKlant_Id() {
		return klant_Id;
	}

	public void setKlant_Id(int klant_Id) {
		this.klant_Id = klant_Id;
	}

	public klant getKlant() {
		return Klant;
	}

	public void setKlant(klant klant) {
		Klant = klant;
	}
	
	

}
