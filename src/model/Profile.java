package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "Profile")
@Table(name = "PROFILE")
public class Profile implements Serializable{

	private static final long serialVersionUID = 1L;

	
	protected int id;
	protected String profileName;
	protected boolean isSelected;
	protected List<Day> days = new ArrayList<>();
	protected int version;
	protected LocalDateTime created;
	protected LocalDateTime updated;
	
	public Profile() {
		
	}
	
	public void addDays(Day day) {
	
		getDays().add(day);
		day.setOwningProfile(this);
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROFILE_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "PROFILE_NAME")
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	@Column(name = "IS_SELECTED")
	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	@OneToMany(mappedBy = "owningProfile", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Day> getDays() {
		return days;
	}
	public void setDays(List<Day> days) {
		this.days = days;
	}
	
	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Column(name = "CREATED_DATE")
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	@Column(name = "UPDATED_DATE")
	public LocalDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	
}
