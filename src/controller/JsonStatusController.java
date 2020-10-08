package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Addon;
import model.Profile;

@WebServlet("/jsonStatusController")
public class JsonStatusController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private String today;
	private List<Double> activeTimers;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PumpController_PU");
		EntityManager em = emf.createEntityManager();
		
		boolean active = false; //	This boolean determines wether the pump will be active or not
		
		try {
			
			TypedQuery<Addon> findAddonQuery = em.createQuery("Select a From Addon a", Addon.class);
	    	Addon copyOfAddon = findAddonQuery.getSingleResult();
	    	
	    	TypedQuery<Profile> findProfileQuery = em.createQuery("Select p From Profile p Where p.profileName = :param", Profile.class);
	    	findProfileQuery.setParameter("param", copyOfAddon.getSelectedName());
	    	Profile copyOfProfile = findProfileQuery.getSingleResult();
			//em.close();
			
			LocalDate date = LocalDate.now();
			Locale locale = Locale.CANADA;
			DayOfWeek tempDay = date.getDayOfWeek();
			today = tempDay.getDisplayName(TextStyle.FULL, locale);
			
			for(int i = 0; i < copyOfProfile.getDays().size(); i++) {
				
				if(copyOfProfile.getDays().get(i).getDayName().toLowerCase().equals(today.toLowerCase())) {
					
					log("Today is: " + today);
					activeTimers = new ArrayList<>();
					
					if(!copyOfProfile.getDays().get(i).getDayTimer().getTimerA1().isEmpty() 
							&& !copyOfProfile.getDays().get(i).getDayTimer().getTimerA2().isEmpty()) {
						
						char[] chars1 = copyOfProfile.getDays().get(i).getDayTimer().getTimerA1().toCharArray();
						chars1[2] = '.';
						activeTimers.add(Double.parseDouble(String.valueOf(chars1)));
						
						char[] chars2 = copyOfProfile.getDays().get(i).getDayTimer().getTimerA2().toCharArray();
						chars2[2] = '.';
						activeTimers.add(Double.parseDouble(String.valueOf(chars2)));
					}
					
					if(!copyOfProfile.getDays().get(i).getDayTimer().getTimerB1().isEmpty() 
							&& !copyOfProfile.getDays().get(i).getDayTimer().getTimerB2().isEmpty()) {
						
						char[] chars1 = copyOfProfile.getDays().get(i).getDayTimer().getTimerB1().toCharArray();
						chars1[2] = '.';
						activeTimers.add(Double.parseDouble(String.valueOf(chars1)));
						
						char[] chars2 = copyOfProfile.getDays().get(i).getDayTimer().getTimerB2().toCharArray();
						chars2[2] = '.';
						activeTimers.add(Double.parseDouble(String.valueOf(chars2)));
					}
					
					if(!copyOfProfile.getDays().get(i).getDayTimer().getTimerC1().isEmpty() 
							&& !copyOfProfile.getDays().get(i).getDayTimer().getTimerC2().isEmpty()) {
						
						char[] chars1 = copyOfProfile.getDays().get(i).getDayTimer().getTimerC1().toCharArray();
						chars1[2] = '.';
						activeTimers.add(Double.parseDouble(String.valueOf(chars1)));
						
						char[] chars2 = copyOfProfile.getDays().get(i).getDayTimer().getTimerC2().toCharArray();
						chars2[2] = '.';
						activeTimers.add(Double.parseDouble(String.valueOf(chars2)));
					}
				}
			}
			
//			Check timer values
			Date toDate = new Date();
			SimpleDateFormat simpleDate = new SimpleDateFormat("kk:mm");
			char[] nowChars = simpleDate.format(toDate).toCharArray();
			nowChars[2] = '.';
			Double now = Double.valueOf(String.valueOf(nowChars));
			
			for(int i = 0; i < activeTimers.size(); i+=2) {
				
				if(activeTimers.get(i) < activeTimers.get(i + 1)) {
					
					if(now > activeTimers.get(i) && now < activeTimers.get(i + 1)) {
						
						active = true;
					}
					
				}else if(activeTimers.get(i) > activeTimers.get(i + 1)) {
					
					if(now < activeTimers.get(i) && now > activeTimers.get(i + 1)) {
						
						active = true;
					}
				}
			}
			
		}catch(NoResultException e) {
			
		}
		
		//	Override Check
		Addon addon = em.find(Addon.class, 1);
		String overrideStatus = addon.getOverride();
		em.close();
		
		if(overrideStatus.equals("on")) {
			
			active = true;
			
		}else if(overrideStatus.equals("off")) {
			
			active = false;
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		out.print("[{\"id\":\"1\",\"my_value\":\""+active+"\"}]");
		out.flush();
	}
}
