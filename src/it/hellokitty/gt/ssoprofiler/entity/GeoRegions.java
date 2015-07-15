package it.hellokitty.gt.ssoprofiler.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SSO_GEO_REGIONS")
public class GeoRegions implements Serializable {
	private static final long serialVersionUID = -1396605811093405057L;

	@Id 
	@Basic(optional = false)
	@Column(name="ID")
	private String id;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_REGION", referencedColumnName="ID")
	private List<UserRegion> userRegions;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_REGION", referencedColumnName="ID")
	private List<GeoCountries> countries;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_AREA", referencedColumnName="ID")
	private GeoAreas area;

	@Column(name="DESCRIPTION_IT")
	private String descriptionIt;
	
	@Column(name="DESCRIPTION_EN")
	private String descriptionEn;
	
	@Column(name="DESCRIPTION_FR")
	private String descriptionFr;
	
	@Column(name="DESCRIPTION_DE")
	private String descriptionDe;
	
	@Column(name="DESCRIPTION_ES")
	private String descriptionEs;
	
	@Column(name="DESCRIPTION_ZH")
	private String descriptionZh;
	
	@Column(name="DESCRIPTION_JP")
	private String descriptionJp;
	
	@Column(name="DATE_INS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateIns;
	
	@Column(name="DATE_MOD")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMod;
	
	@Column(name="USER_INS")
	private String userIns;
	
	@Column(name="USER_MOD")
	private String userMod;
	
	@Column(name="ACTIVE")
	private String active;
	
	public GeoRegions(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public List<GeoCountries> getCountries() {
		return countries;
	}

	public void setCountries(List<GeoCountries> countries) {
		this.countries = countries;
	}

	public GeoAreas getArea() {
		return area;
	}

	public void setArea(GeoAreas geoArea) {
		this.area = geoArea;
	}

	public String getDescriptionIt() {
		return descriptionIt;
	}

	public void setDescriptionIt(String descriptionIt) {
		this.descriptionIt = descriptionIt;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getDescriptionFr() {
		return descriptionFr;
	}

	public void setDescriptionFr(String descriptionFr) {
		this.descriptionFr = descriptionFr;
	}

	public String getDescriptionDe() {
		return descriptionDe;
	}

	public void setDescriptionDe(String descriptionDe) {
		this.descriptionDe = descriptionDe;
	}

	public String getDescriptionEs() {
		return descriptionEs;
	}

	public void setDescriptionEs(String descriptionEs) {
		this.descriptionEs = descriptionEs;
	}

	public String getDescriptionZh() {
		return descriptionZh;
	}

	public void setDescriptionZh(String descriptionZh) {
		this.descriptionZh = descriptionZh;
	}

	public String getDescriptionJp() {
		return descriptionJp;
	}

	public void setDescriptionJp(String descriptionJp) {
		this.descriptionJp = descriptionJp;
	}
	
	public Date getDateIns() {
		return dateIns;
	}

	public void setDateIns(Date dateIns) {
		this.dateIns = dateIns;
	}

	public Date getDateMod() {
		return dateMod;
	}

	public void setDateMod(Date dateMod) {
		this.dateMod = dateMod;
	}

	public String getUserIns() {
		return userIns;
	}

	public void setUserIns(String userIns) {
		this.userIns = userIns;
	}

	public String getUserMod() {
		return userMod;
	}

	public void setUserMod(String userMod) {
		this.userMod = userMod;
	}

	public Boolean isActive() {
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
			this.active = "N";
		}
	}

	public List<UserRegion> getUserRegions() {
		return userRegions;
	}

	public void setUserRegions(List<UserRegion> userRegions) {
		this.userRegions = userRegions;
	}
}