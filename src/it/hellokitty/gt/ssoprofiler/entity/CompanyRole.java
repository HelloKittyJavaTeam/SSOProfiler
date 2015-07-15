package it.hellokitty.gt.ssoprofiler.entity;

import java.io.Serializable;

import it.hellokitty.gt.entity.BaseObject;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the COMPANY_ROLE database table.
 * 
 */
@Entity
@Table(name="SSO_COMPANY_ROLE")
public class CompanyRole extends BaseObject implements Serializable{
	private static final long serialVersionUID = -7491940452600487056L;

	@Id
	@GeneratedValue(generator = "SEQ_COMPANY_ROLE_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="SEQ_COMPANY_ROLE_ID", allocationSize = 1, initialValue = 0)
	@Basic(optional = false)
	@Column(name="ID")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	public CompanyRole(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
