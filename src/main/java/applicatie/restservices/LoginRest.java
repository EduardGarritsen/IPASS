package applicatie.restservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import applicatie.dao.klantDao;
import applicatie.dao.klantDaoImpl;
import applicatie.model.*;

@Path("/index")
public class LoginRest {
	@POST
	@Path("/inloggen")
	@Produces("application/json")
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	public Response inloggen(@FormParam("email") String email, @FormParam("wachtwoord") String wachtwoord) {
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
	/*	try {
			
			authenticate(email, wachtwoord);
			
			String token = issueToken(email);
			
			NewCookie cookie = new NewCookie("token", token);
			
		    return Response.ok(token).cookie(cookie).build();
			
		} catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }   
	}
	
	private void authenticate(String email, String wachtwoord) throws Exception {
		klantDao kDao = new klantDaoImpl();
		klant k = kDao.findKlantByEmailAndWachtwoord(email, wachtwoord);
    }
	
    private String issueToken(String email) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
    	try {
    	    Algorithm algorithm = Algorithm.HMAC256("secret");
    	    email = JWT.create()
    	        .withIssuer("auth0")
    	        .sign(algorithm);
    	} catch (JWTCreationException exception){
    	    //Invalid Signing configuration / Couldn't convert Claims.
    	}
    	return email; */
