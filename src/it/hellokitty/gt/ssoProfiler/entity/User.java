package it.hellokitty.gt.ssoProfiler.entity;

import it.hellokitty.gt.entity.BaseObject;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the USER database table.
 * 
 */
@Entity
@Table(name="SSO_USER")
public class User extends BaseObject implements Serializable{
	private static final long serialVersionUID = 8600174910948142123L;

	@Id
	@GeneratedValue(generator = "SEQ_USER_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="SEQ_USER_ID", allocationSize = 1, initialValue = 0)
	@Basic(optional = false)
	@Column(name="ID")
	private long id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;
	
	@Column(name="DEALER_CODE")
	private String dealerCode;
	
	@Column(name="DOMAIN_CODE")
	private String domainCode;
	
	@Column(name="LOGIN_MODIS")
	private String loginModis;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="SSO_USER_ROLE",
			joinColumns=@JoinColumn(name="USER_ID"),
			inverseJoinColumns=@JoinColumn(name="ROLE_ID"))
	private List<Role> roles;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_USER", referencedColumnName="ID")
	private List<UserArea> userArea;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_USER", referencedColumnName="ID")
	private List<UserRegion> userRegion;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_USER", referencedColumnName="ID")
	private List<UserCountry> userCountry;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_USER", referencedColumnName="ID")
	private List<UserDealer> userDealer;

	public User(){}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getDomainCode() {
		return domainCode;
	}

	public void setDomainCode(String domainCode) {
		this.domainCode = domainCode;
	}

	public String getLoginModis() {
		return loginModis;
	}

	public void setLoginModis(String loginModis) {
		this.loginModis = loginModis;
	}

	public List<UserArea> getUserArea() {
		return userArea;
	}

	public void setUserArea(List<UserArea> userArea) {
		this.userArea = userArea;
	}

	public List<UserRegion> getUserRegion() {
		return userRegion;
	}

	public void setUserRegion(List<UserRegion> userRegion) {
		this.userRegion = userRegion;
	}

	public List<UserCountry> getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(List<UserCountry> userCountry) {
		this.userCountry = userCountry;
	}

	public List<UserDealer> getUserDealer() {
		return userDealer;
	}

	public void setUserDealer(List<UserDealer> userDealer) {
		this.userDealer = userDealer;
	}
}