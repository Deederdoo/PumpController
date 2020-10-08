package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "DayTimer")
@Table(name = "DAYTIMER")
public class DayTimer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected String timerA1;
	protected String timerA2;
	protected String timerB1;
	protected String timerB2;
	protected String timerC1;
	protected String timerC2;
	protected Day owningDay;
	
	public DayTimer() {
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DAYTIMER_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "TIMER_A1")
	public String getTimerA1() {
		return timerA1;
	}
	public void setTimerA1(String timerA1) {
		this.timerA1 = timerA1;
	}
	
	@Column(name = "TIMER_A2")
	public String getTimerA2() {
		return timerA2;
	}
	public void setTimerA2(String timerA2) {
		this.timerA2 = timerA2;
	}
	
	@Column(name = "TIMER_B1")
	public String getTimerB1() {
		return timerB1;
	}
	public void setTimerB1(String timerB1) {
		this.timerB1 = timerB1;
	}
	
	@Column(name = "TIMER_B2")
	public String getTimerB2() {
		return timerB2;
	}
	public void setTimerB2(String timerB2) {
		this.timerB2 = timerB2;
	}
	
	@Column(name = "TIMER_C1")
	public String getTimerC1() {
		return timerC1;
	}
	public void setTimerC1(String timerC1) {
		this.timerC1 = timerC1;
	}
	
	@Column(name = "TIMER_C2")
	public String getTimerC2() {
		return timerC2;
	}
	public void setTimerC2(String timerC2) {
		this.timerC2 = timerC2;
	}
	
	@OneToOne(mappedBy = "dayTimer")
	public Day getOwningDay() {
		return owningDay;
	}
	public void setOwningDay(Day owningDay) {
		this.owningDay = owningDay;
	}
}
