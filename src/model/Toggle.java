package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Toggle")
@Table(name = "TOGGLE")
public class Toggle implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	private int id;
	private boolean isToggle;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TOGGLE_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "ISTOGGLE")
	public boolean isToggle() {
		return isToggle;
	}
	public void setToggle(boolean isToggle) {
		this.isToggle = isToggle;
	}
	
}
