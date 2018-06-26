package applicatie.restservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import applicatie.dao.bestellingDao;
import applicatie.dao.bestellingDaoImpl;
import applicatie.model.bestelling;

@Path("/bestelling")
public class bestellingAfleveren {
	@GET
	@Path("/afleveren")
	public String getBestellingen() {
		
		bestellingDao bDoa = new bestellingDaoImpl();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		String status = "gereed";
		
		for (bestelling b : bDoa.selectBestellingByStatus(status)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("bestellingId", b.getBestelling_ID());
			job.add("Tafel", b.getTafel());
			job.add("gerecht", b.getGerecht());
			job.add("prijs", b.getPrijs());
			job.add("klantId", b.getKlant_Id());
			jab.add(job);
		}
		
		
		JsonArray bestellingenInAfwachting = jab.build();
		
		System.out.println(bestellingenInAfwachting);
		
		return bestellingenInAfwachting.toString();
	}
	
	@POST
	@Path("/afgeleverd")
	public void deleteBestelling(@FormParam("bestellingId") int bestelling_Id) {
		
		System.out.println(bestelling_Id);
		
		bestellingDao bDoa = new bestellingDaoImpl();
		
		bDoa.deleteBestellingById(bestelling_Id);
	}
}