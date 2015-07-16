package it.hellokitty.gt.ssoprofiler.entity;

import java.io.Serializable;

import it.hellokitty.gt.entity.BaseObject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the USER_COUNTRY database table.
 * 
 */
@Entity
@Table(name="SSO_USER_COUNTRY")
public class UserCountry extends BaseObject implements Serializable{
	private static final long serialVersionUID = -6875868955780861521L;

	@Id
	@Column(name="ID")
	private long id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_USER")
	private AdUsers user;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_COUNTRY")
	private GeoCountries country;

	public UserCountry() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GeoCountries getGeoCountry() {
		return country;
	}

	public void setGeoCountry(GeoCountries geoCountry) {
		this.country = geoCountry;
	}

	public AdUsers getUser() {
		return user;
	}

	public void setUser(AdUsers user) {
		this.user = user;
	}
}