package applicatie.restservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

import applicatie.dao.*;
import applicatie.model.*;

@Path("/bestellen")
public class bestellen {
	@GET
	@Path("/inzien")
	public String getMenukaart() {
			
		menuDao mDao = new menuDaoImpl();
		JsonArrayBuilder jab = Json.createArrayBuilder();
			
		for (menu m : mDao.findMenukaart()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("Gerecht", m.getGerecht());
			job.add("Prijs", m.getPrijs());
			if(m.getBeschrijving() != null) {
				job.add("beschrijving", m.getBeschrijving());
			}
			jab.add(job);
			}
			
		JsonArray menukaart = jab.build();
			
			return menukaart.toString();
		}
}
