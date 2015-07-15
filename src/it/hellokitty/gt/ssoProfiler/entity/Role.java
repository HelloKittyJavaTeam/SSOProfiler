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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the ROLE database table.
 * 
 */
@Entity
@Table(name="SSO_ROLE")
public class Role extends BaseObject implements Serializable{
	private static final long serialVersionUID = -1393982859103555031L;

	@Id
	@GeneratedValue(generator = "SEQ_ROLE_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="SEQ_ROLE_ID", allocationSize = 1, initialValue = 0)
	@Basic(optional = false)
	@Column(name="ID")
	private long id;
	
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="APPLICATION_ID")
	private Application application;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="SSO_USER_ROLE",
			joinColumns=@JoinColumn(name="ID_ROLE"),
			inverseJoinColumns=@JoinColumn(name="ID_USER"))
	private List<User> users;

	public Role() {}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}