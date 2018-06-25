package applicatie.restservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

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
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		if (k == null) {
			throw new WebApplicationException("No such order!");
		}
		
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("Klant_Id", k.getKlant_Id());
		job.add("naam", k.getNaam());
		job.add("wachtwoord", wachtwoord);
		job.add("email", email);
		
		jab.add(job);
		
		JsonArray klantGegevens = jab.build();
		
		System.out.println(klantGegevens);
				
		return klantGegevens.toString();
	}
}