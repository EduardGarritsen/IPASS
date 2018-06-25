package applicatie.dao;

import java.util.ArrayList;

import applicatie.model.*;

public interface reserveringDao {
	public ArrayList<reservering> findReserveringen();
	public reservering insertReservering(reservering reservering);
}
