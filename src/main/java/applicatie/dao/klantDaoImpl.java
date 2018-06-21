package applicatie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import applicatie.model.*;
import applicatie.dao.MysqlBaseDao;

public class klantDaoImpl extends MysqlBaseDao implements klantDao {
	
	public klant findKlantByEmailAndWachtwoord(String email, String wachtwoord) {
		
		klant k = null;
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM slufter.klant " + 
					"WHERE email = '" + email + "' AND Wachtwoord = '" + wachtwoord + "';");
			ResultSet myRs = stmt.executeQuery();
			
			
			while (myRs.next()) {
				k = new klant(
					myRs.getInt("Klant_ID"),
					myRs.getString("Naam"),
					myRs.getString("Wachtwoord"),
					myRs.getString("email"));
			}
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return k;
	}
}
