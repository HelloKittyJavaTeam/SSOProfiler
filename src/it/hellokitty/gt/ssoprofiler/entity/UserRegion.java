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
 * The persistent class for the USER_REGION database table.
 * 
 */
@Entity
@Table(name="SSO_USER_REGION")
public class UserRegion extends BaseObject implements Serializable{
	private static final long serialVersionUID = -8666937832212799947L;

	@Id
	@Column(name="ID")
	private long id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_USER")
	private AdUsers user;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_REGION")
	private GeoRegions region;

	public UserRegion() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public GeoRegions getRegion() {
		return region;
	}

	public void setGeoRegion(GeoRegions region) {
		this.region = region;
	}

	public AdUsers getUser() {
		return user;
	}

	public void setUser(AdUsers user) {
		this.user = user;
	}
}