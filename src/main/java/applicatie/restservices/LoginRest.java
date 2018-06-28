package applicatie.restservices;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import applicatie.dao.klantDao;
import applicatie.dao.klantDaoImpl;
import applicatie.model.*;

@Path("/index")
public class LoginRest {
	@POST
	@Path("/inloggen")
	@Produces("application/json")
	public String inloggen(@FormParam("email") String email, @FormParam("wachtwoord") String wachtwoord) {
		System.out.println(email + ", " + wachtwoord);

		klantDao kDao = new klantDaoImpl();
		klant k = kDao.findKlantByEmailAndWachtwoord(email, wachtwoord);

		if (k == null) {
			throw new WebApplicationException("No such order!");
		}

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("Klant_Id", k.getKlant_Id());

		JsonObject klantGegevens = job.build();

		System.out.println(klantGegevens);
				
		return klantGegevens.toString();
	}
}
