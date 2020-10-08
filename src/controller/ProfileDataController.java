package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profile;

@WebServlet("/profileDataController")
public class ProfileDataController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.addHeader("Access-Control-Allow-Origin", "*");
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PumpController_PU");
		EntityManager em = emf.createEntityManager();
		
		String profileReq = req.getParameter("profileN");
		
		if(!profileReq.equals("Default")) {
			
			TypedQuery<Profile> findProfileQuery =
	    			em.createQuery("Select p From Profile p Where p.profileName = :param", Profile.class);
			findProfileQuery.setParameter("param", profileReq);
	    	Profile copyOfProfile = findProfileQuery.getSingleResult();
			em.close();
	    	
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			
			out.print(copyOfProfile.getId());	//Id of the selected profile (for use with edit)
			out.print(",");
			
			for(int i = 0; i < copyOfProfile.getDays().size(); i++) {
				
				out.print(copyOfProfile.getDays().get(i).getDayTimer().getTimerA1());
				out.print(",");
				out.print(copyOfProfile.getDays().get(i).getDayTimer().getTimerA2());
				out.print(",");
				out.print(copyOfProfile.getDays().get(i).getDayTimer().getTimerB1());
				out.print(",");
				out.print(copyOfProfile.getDays().get(i).getDayTimer().getTimerB2());
				out.print(",");
				out.print(copyOfProfile.getDays().get(i).getDayTimer().getTimerC1());
				out.print(",");
				out.print(copyOfProfile.getDays().get(i).getDayTimer().getTimerC2());
				
				if(i < (copyOfProfile.getDays().size() - 1)){
					
					out.print(",");
				}
			}
			
	        out.flush();
		}
	}
}
