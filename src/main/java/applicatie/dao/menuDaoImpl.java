package applicatie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import applicatie.model.menu;
import applicatie.dao.MysqlBaseDao;

public class menuDaoImpl extends MysqlBaseDao implements menuDao {
	
	public ArrayList<menu> findMenukaart() {
		ArrayList<menu> menukaart = new ArrayList<menu>();
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM slufter.menu");
			ResultSet myRs = stmt.executeQuery();
			
			while (myRs.next()) {
				String gerecht = myRs.getString("gerecht");
				Float prijs = myRs.getFloat("prijs");
				String beschrijving = myRs.getString("beschrijving");
				menu menu = new menu(gerecht, prijs, beschrijving);
				menukaart.add(menu);
			}
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return menukaart;
	}
}
