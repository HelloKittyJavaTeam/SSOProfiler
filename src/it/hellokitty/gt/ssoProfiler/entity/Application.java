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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the APPLICATION database table.
 * 
 */
@Entity
@Table(name="SSO_APPLICATION")
public class Application extends BaseObject implements Serializable{
	private static final long serialVersionUID = 4169440958300371190L;

	@Id
	@GeneratedValue(generator = "SEQ_APPLICATION_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="SEQ_APPLICATION_ID", allocationSize = 1, initialValue = 0)
	@Basic(optional = false)
	@Column(name="ID")
	private long id;
	
	private String name;

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="APPLICATION_ID", referencedColumnName="ID")
	private List<Role> roles;

	public Application() {}

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
