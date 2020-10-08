package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Day")
@Table(name = "DAY")
public class Day implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	protected int id;
	protected String dayName;
	protected Profile owningProfile;
	protected DayTimer dayTimer;
	
	public Day() {
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DAY_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "OWNING_PROFILE")
	public Profile getOwningProfile() {
		return owningProfile;
	}
	public void setOwningProfile(Profile owningProfile) {
		this.owningProfile = owningProfile;
	}
	
	@Column(name = "DAY_NAME")
	public String getDayName() {
		return dayName;
	}
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	
	@OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "DAYTIMER_ID")
	public DayTimer getDayTimer() {
		return dayTimer;
	}
	public void setDayTimer(DayTimer dayTimer) {
		this.dayTimer = dayTimer;
	}
}
