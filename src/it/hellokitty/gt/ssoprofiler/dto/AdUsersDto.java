package it.hellokitty.gt.ssoprofiler.dto;

import it.hellokitty.gt.ssoprofiler.entity.AdUsers;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The DTO class for the AdUsers entities
 * 
 */
public class AdUsersDto implements Serializable {
	private static final long serialVersionUID = -3043139478270352581L;

	private Long id;
	
	private String active;

	private String company;

	private String costCenter;

	private Date dateIns;

	private Date dateLastUpdate;

	private Date dateMod;

	private String email;

	private String fax;

	private String feGroup;

	private String feRole;

	private String firstName;

	private String language;

	private String lastName;

	private String password;

	private String phone;

	private String source;

	private String status;

	private String userIns;

	private String userMod;

	private String username;

	public AdUsersDto() {}

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
	
	/**
	 * This method returns an AdUsersDTO of the adUsers input parameter
	 * 
	 * @param adUsers
	 * @return AdUsersDto
	 */
	public static AdUsersDto from( final AdUsers adUsers ) {
		AdUsersDto dto = new AdUsersDto();
		dto.setActive(adUsers.isActive());
		dto.setCompany(adUsers.getCompany());
		dto.setCostCenter(adUsers.getCostCenter());
		dto.setDateIns(adUsers.getDateIns());
		dto.setDateLastUpdate(adUsers.getDateLastUpdate());
		dto.setDateMod(adUsers.getDateMod());
		dto.setEmail(adUsers.getEmail());
		dto.setFax(adUsers.getFax());
		dto.setFeGroup(adUsers.getFeGroup());	
		dto.setFeRole(adUsers.getFeRole());
		dto.setFirstName(adUsers.getFirstName());
		dto.setId(adUsers.getId());
		dto.setLanguage(adUsers.getLanguage());
		dto.setLastName(adUsers.getLastName());
		dto.setPassword(adUsers.getPassword());
		dto.setPhone(adUsers.getPhone());
		dto.setSource(adUsers.getSource());
		dto.setStatus(adUsers.getStatus());
		dto.setUserIns(adUsers.getUserIns());
		dto.setUserMod(adUsers.getUserMod());
		dto.setUsername(adUsers.getUsername());
		return dto;
	}
	
	/**
	 * This method returns a List of AdUsersDto of the List of adUsersList input parameter
	 * 
	 * @param adUsersList List
	 * @return List of AdUsers
	 */
	public static List<AdUsersDto> from( final List<AdUsers> adUsersList ) {
		final List<AdUsersDto> adUsersDto = new LinkedList<AdUsersDto>();
		for ( final AdUsers adUsers : adUsersList ) {
			adUsersDto.add( from( adUsers ) );
		}
		return adUsersDto;
	}
}