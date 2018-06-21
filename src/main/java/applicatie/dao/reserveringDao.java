package applicatie.dao;

import applicatie.model.*;

public interface reserveringDao {
	public reservering insertReservering(int reservering_Id, String datum, String tijd, int tafel, int klant_Id);
}
