package applicatie.dao;

import applicatie.model.*;

public interface klantDao {
	public klant findKlantByEmailAndWachtwoord(String email, String wachtwoord);
}
