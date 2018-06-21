package applicatie.model;

public class reservering {
	
	private int reservering_Id;
	private String datum;
	private String tijd;
	private int tafel;
	private int klant_Id;
	private klant Klant;
	
	public reservering(int reservering_Id, String datum, String tijd, int tafel, int klant_Id) {
		
		this.reservering_Id = reservering_Id;
		this.datum = datum;
		this.tijd = tijd;
		this.tafel = tafel;
		this.klant_Id = klant_Id;
	}

	public int getReservering_Id() {
		return reservering_Id;
	}

	public void setReservering_Id(int reservering_Id) {
		this.reservering_Id = reservering_Id;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getTijd() {
		return tijd;
	}

	public void setTijd(String tijd) {
		this.tijd = tijd;
	}

	public int getTafel() {
		return tafel;
	}

	public void setTafel(int tafel) {
		this.tafel = tafel;
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
