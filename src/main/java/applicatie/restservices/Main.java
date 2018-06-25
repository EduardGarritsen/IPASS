package applicatie.restservices;

import applicatie.dao.*;
import applicatie.model.*;

public class Main 
{
    public static void main( String[] args ) {
        menuDao mDao = new menuDaoImpl();
        klantDao kDao = new klantDaoImpl();
        reserveringDao rDao = new reserveringDaoImpl();
        
        System.out.println(kDao.findKlantByEmailAndWachtwoord("willemvonk@gmail.com", "Geheim").getNaam());
        
        for(int i = 0; i < mDao.findMenukaart().size(); i ++) {
        	System.out.println(mDao.findMenukaart().get(i).getGerecht());
        }
        
        for(int i = 0; i < rDao.findReserveringen().size(); i ++) {
        	System.out.println(rDao.findReserveringen().get(i).getDatum());
        }
        
        }
}
