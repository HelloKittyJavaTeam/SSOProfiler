package it.hellokitty.gt.ssoProfiler.entity;

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
 * The persistent class for the USER_AREA database table.
 * 
 */
@Entity
@Table(name="SSO_USER_AREA")
public class UserArea extends BaseObject implements Serializable{
	private static final long serialVersionUID = -9078124626680114855L;

	@Id
	@Column(name="ID")
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_USER")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_AREA")
	private GeoAreas geoArea;

	public UserArea() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GeoAreas getGeoArea() {
		return geoArea;
	}

	public void setGeoArea(GeoAreas geoArea) {
		this.geoArea = geoArea;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}