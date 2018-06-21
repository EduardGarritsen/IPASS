package applicatie.restservices;

import applicatie.dao.*;
import applicatie.model.*;

public class Main 
{
    public static void main( String[] args ) {
        menuDao mDao = new menuDaoImpl();
        klantDao kDao = new klantDaoImpl();
        
        System.out.println(kDao.findKlantByEmailAndWachtwoord("willemvonk@gmail.com", "geheim").getNaam());
        
        for(int i = 0; i < mDao.findMenukaart().size(); i ++) {
        	System.out.println(mDao.findMenukaart().get(i).getGerecht());
        }
    }
}
