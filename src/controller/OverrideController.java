package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Addon;

@WebServlet("/overrideController")
public class OverrideController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PumpController_PU");
		EntityManager em = emf.createEntityManager();
		
		String overrideStatus = req.getParameter("overrideV");
		String overrideIsSet = req.getParameter("overrideS");
		
		if(overrideStatus !=null) {
			
			if(overrideStatus.equals("on")) {	//	Status On
				log("Called ON");
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				Addon addon = em.find(Addon.class, 1);
				addon.setOverride("on");
				tx.commit();
				em.close();
				
			}else if(overrideStatus.equals("off")) {	//	Status Off
				log("Called OFF");
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				Addon addon = em.find(Addon.class, 1);
				addon.setOverride("off");
				tx.commit();
				em.close();
				
			}else{	//	Status Kill
				log("Called KILL");
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				Addon addon = em.find(Addon.class, 1);
				addon.setOverride("kill");
				tx.commit();
				em.close();
			}
			
			//resp.sendRedirect("table.html");
		}
		
		if(overrideIsSet != null) {
			
			if(overrideIsSet.equals("isSet")) {
				
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				Addon addon = em.find(Addon.class, 1);
				String tempOverride = addon.getOverride();
				tx.commit();
				em.close();
				
				log("OVERIDE---------------------------------" + tempOverride);
				
				out.print(tempOverride);
				out.flush();
			}
		}
	}
}
