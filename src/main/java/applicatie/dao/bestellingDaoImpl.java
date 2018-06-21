package applicatie.dao;

import java.sql.*;

import applicatie.model.bestelling;

public class bestellingDaoImpl extends MysqlBaseDao implements bestellingDao {
	
	public bestelling selectBestellingByStatusAndId(int bestelling_ID, String status) {
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT * FROM slufter.bestelling WHERE Bestelling_ID = ? AND Status = ?;");
			stmt.setInt(1, bestelling_ID);
			stmt.setString(2, status);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				int Tafel = rs.getInt("Tafel");
				String gerecht = rs.getString("Gerecht");
				Float prijs = rs.getFloat("Prijs");
				int klant_Id = rs.getInt("Klant_ID");
				bestelling bestelling = new bestelling(
						bestelling_ID, Tafel, gerecht, prijs, status, klant_Id);
				return bestelling;
			}
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

	public bestelling insertBestelling(bestelling bestelling) {
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(
					"INSERT INTO `slufter`.`bestelling`" +
					"(`Bestelling_ID`, `Tafel`, `Gerecht`, `prijs`, `Status`, `Klant_ID`) " +
					"VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, bestelling.getBestelling_ID());
			stmt.setInt(2, bestelling.getTafel());
			stmt.setString(3, bestelling.getGerecht());
			stmt.setString(4, bestelling.getStatus());
			stmt.setInt(5, bestelling.getKlant_Id());
			stmt.execute();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return bestelling;
	}
	
	public bestelling updateBestelling(bestelling bestelling) {
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(
					"UPDATE `slufter`.`bestelling` SET `Status` = ? " +
					" WHERE (`Bestelling_ID` = ?)");
			stmt.setInt(2, bestelling.getBestelling_ID());
			stmt.setString(1, bestelling.getStatus());
			stmt.execute();
			con.close();
		}catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return bestelling;		
	}
	
	public bestelling deleteBestellingById(int bestelling_ID) {
		bestelling bestelling = new bestelling();
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(
					"DELETE FROM `slufter`.`bestelling` WHERE `Bestelling_ID` = ?");
			stmt.setInt(1, bestelling_ID);
			stmt.execute();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		bestelling.setBestelling_ID(bestelling_ID);
		return bestelling;
	}
}
