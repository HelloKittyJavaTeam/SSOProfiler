package it.hellokitty.gt.ssoprofiler.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the AD_USERS database table.
 * 
 */
@Entity
@Table(name="SSO_AD_USERS")
public class AdUsers implements Serializable {
	private static final long serialVersionUID = 2927991163881025898L;

	@Id
	private Long id;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="SSO_USER_ROLE",
			joinColumns=@JoinColumn(name="ID_USER"),
			inverseJoinColumns=@JoinColumn(name="ID_ROLE"))
	private List<Role> roles;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="SSO_USER_AREA",
			joinColumns=@JoinColumn(name="ID_USER"),
			inverseJoinColumns=@JoinColumn(name="ID_GEO_AREAS"))
	private List<GeoAreas> areas;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="SSO_USER_REGIONS",
			joinColumns=@JoinColumn(name="ID_USER"),
			inverseJoinColumns=@JoinColumn(name="ID_GEO_REGIONS"))
	private List<GeoRegions> regions;

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="SSO_USER_COUNTRIES",
			joinColumns=@JoinColumn(name="ID_USER"),
			inverseJoinColumns=@JoinColumn(name="ID_GEO_COUNTRIES"))
	private List<GeoCountries> countries;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="SSO_USER_DEALERS",
			joinColumns=@JoinColumn(name="ID_USER"),
			inverseJoinColumns=@JoinColumn(name="ID_DEALERS"))
	private List<Dealers> dealers;
	
	private String active;

	private String company;

	@Column(name="COST_CENTER")
	private String costCenter;

	@Column(name="DATE_INS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateIns;

	@Column(name="DATE_LAST_UPDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateLastUpdate;

	@Column(name="DATE_MOD")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMod;

	private String email;

	private String fax;

	@Column(name="FE_GROUP")
	private String feGroup;

	@Column(name="FE_ROLE")
	private String feRole;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LANGUAGE")
	private String language;

	@Column(name="LAST_NAME")
	private String lastName;

	private String password;

	private String phone;

	private String source;

	private String status;

	@Column(name="USER_INS")
	private String userIns;

	@Column(name="USER_MOD")
	private String userMod;

	private String username;

	public AdUsers() {}

	public boolean isActive() {
		if(active.equals("Y")){
			return true;
		} else {
			return false;
		}
	}

	public void setActive(boolean active) {
		if(active){
			this.active = "Y";
		} else {
			this.active ="N";
		}
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public Date getDateIns() {
		return this.dateIns;
	}

	public void setDateIns(Date dateIns) {
		this.dateIns = dateIns;
	}

	public Date getDateLastUpdate() {
		return this.dateLastUpdate;
	}

	public void setDateLastUpdate(Date dateLastUpdate) {
		this.dateLastUpdate = dateLastUpdate;
	}

	public Date getDateMod() {
		return this.dateMod;
	}

	public void setDateMod(Date dateMod) {
		this.dateMod = dateMod;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFeGroup() {
		return this.feGroup;
	}

	public void setFeGroup(String feGroup) {
		this.feGroup = feGroup;
	}

	public String getFeRole() {
		return this.feRole;
	}

	public void setFeRole(String feRole) {
		this.feRole = feRole;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserIns() {
		return this.userIns;
	}

	public void setUserIns(String userIns) {
		this.userIns = userIns;
	}

	public String getUserMod() {
		return this.userMod;
	}

	public void setUserMod(String userMod) {
		this.userMod = userMod;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Dealers> getDealers() {
		return dealers;
	}

	public void setDealers(List<Dealers> dealers) {
		this.dealers = dealers;
	}

	public List<GeoAreas> getAreas() {
		return areas;
	}

	public void setAreas(List<GeoAreas> areas) {
		this.areas = areas;
	}

	public List<GeoRegions> getRegions() {
		return regions;
	}

	public void setRegions(List<GeoRegions> regions) {
		this.regions = regions;
	}

	public List<GeoCountries> getCountries() {
		return countries;
	}

	public void setCountries(List<GeoCountries> countries) {
		this.countries = countries;
	}
}