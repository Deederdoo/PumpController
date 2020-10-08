package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Addon")
@Table(name = "ADDON")
public class Addon implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	private int id;
	private String override;
	private String selectedName;
	
	public Addon() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDON_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "OVERRIDE")
	public String getOverride() {
		return override;
	}
	public void setOverride(String override) {
		this.override = override;
	}
	
	@Column(name = "SELECTED_NAME")
	public String getSelectedName() {
		return selectedName;
	}
	public void setSelectedName(String selectedName) {
		this.selectedName = selectedName;
	}
}
