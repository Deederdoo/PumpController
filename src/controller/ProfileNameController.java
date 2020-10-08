package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Addon;
import model.Profile;

@WebServlet("/profileNameController")
public class ProfileNameController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.addHeader("Access-Control-Allow-Origin", "*");
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PumpController_PU");
		EntityManager em = emf.createEntityManager();
		
		String profileReq = req.getParameter("profileN");
		
		if(profileReq.equals("ALL")) { //Gets all the profile names for the options table
			
			log("------------------------------------------------------------------------------FETCHING TABLE PROFILES");
			
			TypedQuery<Profile> findProfileQuery = em.createQuery("Select p From Profile p", Profile.class);
	    	List<Profile> copyOfProfile = findProfileQuery.getResultList();
			em.close();
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			
			for(int i = 0; i < copyOfProfile.size(); i++) {
				
				out.print(copyOfProfile.get(i).getProfileName());
				
				if(i < (copyOfProfile.size() - 1)) {
					
					out.print(",");
				}
			}
			
			out.flush();
			
		}else {
			
			if(!profileReq.equals("Default")) {
				
				log("---------------------------------------------" + profileReq);
				
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				Addon addon = em.find(Addon.class, 1);
				addon.setSelectedName(profileReq);
				tx.commit();
				em.close();
			}
		}
	}
}
