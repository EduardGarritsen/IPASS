package applicatie.dao;

import applicatie.model.*;

public interface bestellingDao {
	
	public bestelling selectBestellingByStatusAndId(int bestelling_ID, String status);
	public bestelling insertBestelling(bestelling bestelling);
	public bestelling updateBestelling(bestelling bestelling);
	public bestelling deleteBestellingById(int bestelling_ID);
}
