package applicatie.restservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

import applicatie.dao.reserveringDao;
import applicatie.dao.reserveringDaoImpl;
import applicatie.model.reservering;

@Path("/reservering")
public class Reserveren {
	@GET
	@Path("/inzien")
	public String getReserveringen() {
		
		reserveringDao rDao = new reserveringDaoImpl();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (reservering r : rDao.findReserveringen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("Reservering_Id", r.getReservering_Id());
			job.add("Datum", r.getDatum());
			job.add("Tijd", r.getTijd());
			job.add("Tafel", r.getTafel());
			job.add("Klant_Id", r.getKlant_Id());
			
			jab.add(job);
		}
		
		JsonArray reserveringen = jab.build();
		
		return reserveringen.toString();
	}
}
