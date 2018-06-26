package applicatie.dao;

import java.util.ArrayList;

import applicatie.model.*;

public interface bestellingDao {
	
	public ArrayList<bestelling> selectBestellingByStatus(String status);
	public bestelling insertBestelling(bestelling bestelling);
	public bestelling updateBestelling(int bestelling_ID, String status);
	public bestelling deleteBestellingById(int bestelling_ID);
}
