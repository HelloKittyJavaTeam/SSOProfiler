package it.hellokitty.gt.ssoprofiler.dto;

import it.hellokitty.gt.ssoprofiler.entity.CompanyRole;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * The DTO class for CompanyRole entity 
 *
 */
public class CompanyRoleDto implements Serializable{
	private static final long serialVersionUID = -43579041685441261L;

	private long id;

	private String name;
	
	private CompanyRoleDto(){}

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
	
	/**
	 * This method returns an CompanyRoleDto of the companyRole input parameter
	 * 
	 * @param companyRole
	 * @return CompanyRoleDto
	 */
	public static CompanyRoleDto from( final CompanyRole companyRole ) {
		CompanyRoleDto dto = new CompanyRoleDto();

		dto.setId(companyRole.getId());
		dto.setName(companyRole.getName());
		
		return dto;
	}
	
	/**
	 * This method returns a List of CompanyRoleDto of the List of companyRoleList input parameter
	 * 
	 * @param companyRoleList List
	 * @return List of CompanyRoleDto
	 */
	public static List<CompanyRoleDto> from( final List<CompanyRole> companyRoleList ) {
		final List<CompanyRoleDto> companyRoleDto = new LinkedList<CompanyRoleDto>();
		for ( final CompanyRole companyRole : companyRoleList ) {
			companyRoleDto.add( from( companyRole ) );
		}
		return companyRoleDto;
	}
}
