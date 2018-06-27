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
	
/*	
	public void bestellen(@FormParam("Tafel") int Tafel, @FormParam("Prijs") int prijs, @FormParam("Klant_Id") int klant_Id) {
		
		String status = "afwachting";
		
		for
		
		bestellingDao bDao = new bestellingDaoImpl();
		
		bestelling b = new bestelling(bestelling_ID, Tafel, prijs, status, klant_Id);
	}
	*/
}
