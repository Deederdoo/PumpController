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
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PumpController_PU");
		EntityManager em = emf.createEntityManager();
		
		String profileReq = req.getParameter("profileN");
		String profileSelect = req.getParameter("profileS");
		
		if(profileReq != null) {
			
			if(profileReq.equals("ALL")) { //Gets all the profile names for the options table
				
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
			}
		}
		
		if(profileSelect != null) {
			
			if(profileSelect.equals("LoadNames")) {	//	Loading the name of the currently selected profile
				
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				Addon addon = em.find(Addon.class, 1);
				String tempName = addon.getSelectedName();
				tx.commit();
				em.close();
				
				out.print(tempName);
				out.flush();
				
			}else {	//	If not loading the names, we are instead setting the selected one
				
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				Addon addon = em.find(Addon.class, 1);
				addon.setSelectedName(profileSelect);
				tx.commit();
				em.close();
			}
		}
	}
}
