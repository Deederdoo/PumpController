package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profile;

@WebServlet("/profileDeleteController")
public class ProfileDeleteController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PumpController_PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Profile profile;
		
		String profileReq = req.getParameter("profileID");
		
		profile = em.find(Profile.class, Integer.valueOf(profileReq));
		
		tx.begin();
		em.remove(profile);
		tx.commit();
		em.close();
		
		log("-----------------------Deleted: " + profile.getProfileName());
		
		resp.sendRedirect("table.html"); //redirect back to the page
	}
}
