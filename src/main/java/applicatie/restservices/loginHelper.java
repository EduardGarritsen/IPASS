package applicatie.restservices;

import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.auth0.jwt.*;

import applicatie.dao.klantDao;
import applicatie.dao.klantDaoImpl;
import applicatie.model.*;

public class loginHelper {
	
	public boolean loginCheck(String email, String wachtwoord) {
		System.out.println(email + ", " + wachtwoord);
		
		boolean bestaat = false;
		
		try {
			klantDao kDao = new klantDaoImpl();
			klant k = kDao.findKlantByEmailAndWachtwoord(email, wachtwoord);
			
			bestaat = true;
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
		
		return bestaat;
	}
}
