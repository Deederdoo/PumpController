package controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PumpDriver {

    public static final String PU_NAME = "PumpController_PU";

    public static void main(String[] args) {
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU_NAME);
        emf.close();
    }
}
