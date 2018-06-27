package applicatie.restservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

import applicatie.dao.*;
import applicatie.model.*;

@Path("/bestelling")
public class bestellingBereiden {
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
	
	@GET
	@Path("/bereiden")
	public String getBestellingen2() {
		
		bestellingDao bDoa = new bestellingDaoImpl();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		String status = "afwachting";
		
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
	@Path("/bereden")
	public void updateBestelling(@FormParam("bestellingId") int bestelling_Id) {
		
		System.out.println(bestelling_Id);
		String status = "gereed";
		
		bestellingDao bDoa = new bestellingDaoImpl();
		
		bDoa.updateBestelling(bestelling_Id, status);
	}
}
