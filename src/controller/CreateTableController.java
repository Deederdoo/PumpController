package controller;

import java.io.IOException;

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

import model.Day;
import model.DayTimer;
import model.Profile;

@WebServlet("/createTableController")
public class CreateTableController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log("Saving... ------------------------------------------------");
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PumpController_PU");
		
		Profile profile = new Profile();

		//EntityManager-----------------------------------------------------
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		if(request.getParameter("input_edittablename").isEmpty()) {
			
			//New table/profile name-------------------------------------
			profile.setProfileName(request.getParameter("input_newtablename"));
			
			//Monday timers---------------------------------------
			DayTimer mondayTimer = new DayTimer();
			Day mondayDay = new Day();
			String monday1 = request.getParameter("monday1");
			String monday1t = request.getParameter("monday1t");
			mondayTimer.setTimerA1(monday1);
			mondayTimer.setTimerA2(monday1t);
			
			String monday2 = request.getParameter("monday2");
			String monday2t = request.getParameter("monday2t");
			mondayTimer.setTimerB1(monday2);
			mondayTimer.setTimerB2(monday2t);
			
			String monday3 = request.getParameter("monday3");
			String monday3t = request.getParameter("monday3t");
			mondayTimer.setTimerC1(monday3);
			mondayTimer.setTimerC2(monday3t);
			
			mondayDay.setDayName("monday");
			mondayDay.setDayTimer(mondayTimer);
			profile.addDays(mondayDay);
			
			//Tuesday timers---------------------------------------
			DayTimer tuesdayTimer = new DayTimer();
			Day tuesdayDay = new Day();
			String tuesday1 = request.getParameter("tuesday1");
			String tuesday1t = request.getParameter("tuesday1t");
			tuesdayTimer.setTimerA1(tuesday1);
			tuesdayTimer.setTimerA2(tuesday1t);
			
			String tuesday2 = request.getParameter("tuesday2");
			String tuesday2t = request.getParameter("tuesday2t");
			tuesdayTimer.setTimerB1(tuesday2);
			tuesdayTimer.setTimerB2(tuesday2t);
			
			String tuesday3 = request.getParameter("tuesday3");
			String tuesday3t = request.getParameter("tuesday3t");
			tuesdayTimer.setTimerC1(tuesday3);
			tuesdayTimer.setTimerC2(tuesday3t);
			
			tuesdayDay.setDayName("tuesday");
			tuesdayDay.setDayTimer(tuesdayTimer);
			profile.addDays(tuesdayDay);
			
			//Wednesday timers---------------------------------------
			DayTimer wednesdayTimer = new DayTimer();
			Day wednesdayDay = new Day();
			String wednesday1 = request.getParameter("wednesday1");
			String wednesday1t = request.getParameter("wednesday1t");
			wednesdayTimer.setTimerA1(wednesday1);
			wednesdayTimer.setTimerA2(wednesday1t);
			
			String wednesday2 = request.getParameter("wednesday2");
			String wednesday2t = request.getParameter("wednesday2t");
			wednesdayTimer.setTimerB1(wednesday2);
			wednesdayTimer.setTimerB2(wednesday2t);
			
			String wednesday3 = request.getParameter("wednesday3");
			String wednesday3t = request.getParameter("wednesday3t");
			wednesdayTimer.setTimerC1(wednesday3);
			wednesdayTimer.setTimerC2(wednesday3t);
			
			wednesdayDay.setDayName("wednesday");
			wednesdayDay.setDayTimer(wednesdayTimer);
			profile.addDays(wednesdayDay);
			
			//Thursday timers---------------------------------------
			DayTimer thursdayTimer = new DayTimer();
			Day thursdayDay = new Day();
			String thursday1 = request.getParameter("thursday1");
			String thursday1t = request.getParameter("thursday1t");
			thursdayTimer.setTimerA1(thursday1);
			thursdayTimer.setTimerA2(thursday1t);
			
			String thursday2 = request.getParameter("thursday2");
			String thursday2t = request.getParameter("thursday2t");
			thursdayTimer.setTimerB1(thursday2);
			thursdayTimer.setTimerB2(thursday2t);
			
			String thursday3 = request.getParameter("thursday3");
			String thursday3t = request.getParameter("thursday3t");
			thursdayTimer.setTimerC1(thursday3);
			thursdayTimer.setTimerC2(thursday3t);
			
			thursdayDay.setDayName("thursday");
			thursdayDay.setDayTimer(thursdayTimer);
			profile.addDays(thursdayDay);
			
			//Friday timers---------------------------------------
			DayTimer fridayTimer = new DayTimer();
			Day fridayDay = new Day();
			String friday1 = request.getParameter("friday1");
			String friday1t = request.getParameter("friday1t");
			fridayTimer.setTimerA1(friday1);
			fridayTimer.setTimerA2(friday1t);
			
			String friday2 = request.getParameter("friday2");
			String friday2t = request.getParameter("friday2t");
			fridayTimer.setTimerB1(friday2);
			fridayTimer.setTimerB2(friday2t);
			
			String friday3 = request.getParameter("friday3");
			String friday3t = request.getParameter("friday3t");
			fridayTimer.setTimerC1(friday3);
			fridayTimer.setTimerC2(friday3t);
			
			fridayDay.setDayName("friday");
			fridayDay.setDayTimer(fridayTimer);
			profile.addDays(fridayDay);
			
			//Saturday timers---------------------------------------
			DayTimer saturdayTimer = new DayTimer();
			Day saturdayDay = new Day();
			String saturday1 = request.getParameter("saturday1");
			String saturday1t = request.getParameter("saturday1t");
			saturdayTimer.setTimerA1(saturday1);
			saturdayTimer.setTimerA2(saturday1t);
			
			String saturday2 = request.getParameter("saturday2");
			String saturday2t = request.getParameter("saturday2t");
			saturdayTimer.setTimerB1(saturday2);
			saturdayTimer.setTimerB2(saturday2t);
			
			String saturday3 = request.getParameter("saturday3");
			String saturday3t = request.getParameter("saturday3t");
			saturdayTimer.setTimerC1(saturday3);
			saturdayTimer.setTimerC2(saturday3t);
			
			saturdayDay.setDayName("saturday");
			saturdayDay.setDayTimer(saturdayTimer);
			profile.addDays(saturdayDay);
			
			//Sunday timers---------------------------------------
			DayTimer sundayTimer = new DayTimer();
			Day sundayDay = new Day();
			String sunday1 = request.getParameter("sunday1");
			String sunday1t = request.getParameter("sunday1t");
			sundayTimer.setTimerA1(sunday1);
			sundayTimer.setTimerA2(sunday1t);
			
			String sunday2 = request.getParameter("sunday2");
			String sunday2t = request.getParameter("sunday2t");
			sundayTimer.setTimerB1(sunday2);
			sundayTimer.setTimerB2(sunday2t);
			
			String sunday3 = request.getParameter("sunday3");
			String sunday3t = request.getParameter("sunday3t");
			sundayTimer.setTimerC1(sunday3);
			sundayTimer.setTimerC2(sunday3t);
			
			sundayDay.setDayName("sunday");
			sundayDay.setDayTimer(sundayTimer);
			profile.addDays(sundayDay);
			
			tx.begin();
			em.persist(profile);
			
		}else {
			
			//Edit table/profile name-------------------------------------
	    	profile = em.find(Profile.class, Integer.valueOf(request.getParameter("currentProfileId")));
			
			profile.setProfileName(request.getParameter("input_edittablename"));
			
			//Monday timers---------------------------------------
			String monday1 = request.getParameter("monday1");
			String monday1t = request.getParameter("monday1t");
			profile.getDays().get(0).getDayTimer().setTimerA1(monday1);
			profile.getDays().get(0).getDayTimer().setTimerA2(monday1t);
			
			String monday2 = request.getParameter("monday2");
			String monday2t = request.getParameter("monday2t");
			profile.getDays().get(0).getDayTimer().setTimerB1(monday2);
			profile.getDays().get(0).getDayTimer().setTimerB2(monday2t);
			
			String monday3 = request.getParameter("monday3");
			String monday3t = request.getParameter("monday3t");
			profile.getDays().get(0).getDayTimer().setTimerC1(monday3);
			profile.getDays().get(0).getDayTimer().setTimerC2(monday3t);
			
			//Tuesday timers---------------------------------------
			String tuesday1 = request.getParameter("tuesday1");
			String tuesday1t = request.getParameter("tuesday1t");
			profile.getDays().get(1).getDayTimer().setTimerA1(tuesday1);
			profile.getDays().get(1).getDayTimer().setTimerA2(tuesday1t);
			
			String tuesday2 = request.getParameter("tuesday2");
			String tuesday2t = request.getParameter("tuesday2t");
			profile.getDays().get(1).getDayTimer().setTimerB1(tuesday2);
			profile.getDays().get(1).getDayTimer().setTimerB2(tuesday2t);
			
			String tuesday3 = request.getParameter("tuesday3");
			String tuesday3t = request.getParameter("tuesday3t");
			profile.getDays().get(1).getDayTimer().setTimerC1(tuesday3);
			profile.getDays().get(1).getDayTimer().setTimerC2(tuesday3t);
			
			//Wednesday timers---------------------------------------
			String wednesday1 = request.getParameter("wednesday1");
			String wednesday1t = request.getParameter("wednesday1t");
			profile.getDays().get(2).getDayTimer().setTimerA1(wednesday1);
			profile.getDays().get(2).getDayTimer().setTimerA2(wednesday1t);
			
			String wednesday2 = request.getParameter("wednesday2");
			String wednesday2t = request.getParameter("wednesday2t");
			profile.getDays().get(2).getDayTimer().setTimerB1(wednesday2);
			profile.getDays().get(2).getDayTimer().setTimerB2(wednesday2t);
			
			String wednesday3 = request.getParameter("wednesday3");
			String wednesday3t = request.getParameter("wednesday3t");
			profile.getDays().get(2).getDayTimer().setTimerC1(wednesday3);
			profile.getDays().get(2).getDayTimer().setTimerC2(wednesday3t);
			
			//Thursday timers---------------------------------------
			String thursday1 = request.getParameter("thursday1");
			String thursday1t = request.getParameter("thursday1t");
			profile.getDays().get(3).getDayTimer().setTimerA1(thursday1);
			profile.getDays().get(3).getDayTimer().setTimerA2(thursday1t);
			
			String thursday2 = request.getParameter("thursday2");
			String thursday2t = request.getParameter("thursday2t");
			profile.getDays().get(3).getDayTimer().setTimerB1(thursday2);
			profile.getDays().get(3).getDayTimer().setTimerB2(thursday2t);
			
			String thursday3 = request.getParameter("thursday3");
			String thursday3t = request.getParameter("thursday3t");
			profile.getDays().get(3).getDayTimer().setTimerC1(thursday3);
			profile.getDays().get(3).getDayTimer().setTimerC2(thursday3t);
			
			//Friday timers---------------------------------------
			String friday1 = request.getParameter("friday1");
			String friday1t = request.getParameter("friday1t");
			profile.getDays().get(4).getDayTimer().setTimerA1(friday1);
			profile.getDays().get(4).getDayTimer().setTimerA2(friday1t);
			
			String friday2 = request.getParameter("friday2");
			String friday2t = request.getParameter("friday2t");
			profile.getDays().get(4).getDayTimer().setTimerB1(friday2);
			profile.getDays().get(4).getDayTimer().setTimerB2(friday2t);
			
			String friday3 = request.getParameter("friday3");
			String friday3t = request.getParameter("friday3t");
			profile.getDays().get(4).getDayTimer().setTimerC1(friday3);
			profile.getDays().get(4).getDayTimer().setTimerC2(friday3t);
			
			//Saturday timers---------------------------------------
			String saturday1 = request.getParameter("saturday1");
			String saturday1t = request.getParameter("saturday1t");
			profile.getDays().get(5).getDayTimer().setTimerA1(saturday1);
			profile.getDays().get(5).getDayTimer().setTimerA2(saturday1t);
			
			String saturday2 = request.getParameter("saturday2");
			String saturday2t = request.getParameter("saturday2t");
			profile.getDays().get(5).getDayTimer().setTimerB1(saturday2);
			profile.getDays().get(5).getDayTimer().setTimerB2(saturday2t);
			
			String saturday3 = request.getParameter("saturday3");
			String saturday3t = request.getParameter("saturday3t");
			profile.getDays().get(5).getDayTimer().setTimerC1(saturday3);
			profile.getDays().get(5).getDayTimer().setTimerC2(saturday3t);
			
			//Sunday timers---------------------------------------
			String sunday1 = request.getParameter("sunday1");
			String sunday1t = request.getParameter("sunday1t");
			profile.getDays().get(6).getDayTimer().setTimerA1(sunday1);
			profile.getDays().get(6).getDayTimer().setTimerA2(sunday1t);
			
			String sunday2 = request.getParameter("sunday2");
			String sunday2t = request.getParameter("sunday2t");
			profile.getDays().get(6).getDayTimer().setTimerB1(sunday2);
			profile.getDays().get(6).getDayTimer().setTimerB2(sunday2t);
			
			String sunday3 = request.getParameter("sunday3");
			String sunday3t = request.getParameter("sunday3t");
			profile.getDays().get(6).getDayTimer().setTimerC1(sunday3);
			profile.getDays().get(6).getDayTimer().setTimerC2(sunday3t);
			
			tx.begin();
			em.merge(profile);
		}
		
		tx.commit();
		em.close();
		
		response.sendRedirect("table.html"); //redirect back to the page
    }
}
