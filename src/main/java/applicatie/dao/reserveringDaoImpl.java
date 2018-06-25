package applicatie.dao;

import java.sql.*;
import java.util.ArrayList;

import applicatie.model.reservering;

public class reserveringDaoImpl extends MysqlBaseDao implements reserveringDao {
	
	public ArrayList<reservering> findReserveringen() {
		ArrayList<reservering> reserveringen = new ArrayList<reservering>();
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM slufter.reservering;");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int reservering_Id = rs.getInt("Reservering_ID");
				String Datum = rs.getString("Datum");
				String Tijd = rs.getString("Tijd");
				int Tafel = rs.getInt("Tafel");
				int klant_Id = rs.getInt("Klant_ID");
				reservering reservering = new reservering(reservering_Id, Datum, Tijd, Tafel, klant_Id);
				reserveringen.add(reservering);
			}
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return reserveringen;
	}
	
	public reservering insertReservering(reservering reservering) {
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("INSERT INTO `slufter`.`reservering` " +
				" (`Reservering_ID`, `Datum`, `Tijd`, `Tafel`, `Klant_ID`) " + 
				" VALUES (?, ?, ?, ?, ?);");
			stmt.setInt(1, reservering.getReservering_Id());
			stmt.setString(2, reservering.getDatum());
			stmt.setString(3, reservering.getTijd());
			stmt.setInt(4, reservering.getTafel());
			stmt.setInt(5, reservering.getKlant_Id());
			stmt.execute();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return reservering;
	}
}
