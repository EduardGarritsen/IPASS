package applicatie.restservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import applicatie.dao.*;
import applicatie.model.*;

@Path("/reservering")
public class Reserveren {
	@GET
	@Path("/inzien")
	public String getReserveringen() {
		
		reserveringDao rDao = new reserveringDaoImpl();
		//klantDao kDao = new klantDaoImpl();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (reservering r : rDao.findReserveringen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			//klant k;
			//k = kDao.findKlantByKlantId(r.getKlant_Id());
			
			job.add("Reservering_Id", r.getReservering_Id());
			job.add("Datum", r.getDatum());
			job.add("Tijd", r.getTijd());
			job.add("Tafel", r.getTafel());
			job.add("Klant_Id", r.getKlant_Id());			
			//job.add("klant_Naam", k.getNaam());
			
			jab.add(job);
		}
		
		JsonArray reserveringen = jab.build();		
		
		System.out.println(reserveringen);
		
		return reserveringen.toString();
	}

	@POST
	@Path("/reserveren")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void Reserveren(@FormParam("datum") String datum, @FormParam("tijd") String Tijd, @FormParam("Tafel") int Tafel, @FormParam("Klant_Id") int klant_Id) {
		
		
		
		System.out.println(datum);
		System.out.println(Tijd);
		System.out.println(Tafel);
		System.out.println(klant_Id);
		reserveringDao rDao = new reserveringDaoImpl();
		
		int reservering_Id = 1;		
		
		for (reservering a : rDao.findReserveringen()) {
			reservering_Id++;
		}
		
		reservering r = new reservering(reservering_Id, datum, Tijd, Tafel, klant_Id);
		System.out.println(r);
		
		rDao.insertReservering(r);
	}
}
