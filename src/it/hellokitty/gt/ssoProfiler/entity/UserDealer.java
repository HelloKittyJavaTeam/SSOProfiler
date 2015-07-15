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
 * The persistent class for the USER_DEALER database table.
 * 
 */
@Entity
@Table(name="SSO_USER_DEALER")
public class UserDealer extends BaseObject implements Serializable{
	private static final long serialVersionUID = -6129824775345735907L;

	@Id
	@Column(name="ID")
	private long id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_USER")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_DEALER")
	private Dealers Dealer;

	public UserDealer() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dealers getDealer() {
		return Dealer;
	}

	public void setDealer(Dealers Dealer) {
		this.Dealer = Dealer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}