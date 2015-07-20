package it.hellokitty.gt.ssoprofiler.dto;

import it.hellokitty.gt.ssoprofiler.entity.Role;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * The DTO class of Role entity 
 *
 */
public class RoleDto implements Serializable{
	private static final long serialVersionUID = 1471055502901320505L;

	private long id;
	
	private String name;

	public RoleDto() {}

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
	
	/**
	 * This method returns an RoleDto of the role input parameter
	 * 
	 * @param role
	 * @return RoleDto
	 */
	public static RoleDto from( final Role role ) {
		RoleDto dto = new RoleDto();

		dto.setId(role.getId());
		dto.setName(role.getName());
		
		return dto;
	}
	
	/**
	 * This method returns a List of RoleDto of the List of roleList input parameter
	 * 
	 * @param roleList List
	 * @return List of RoleDto
	 */
	public static List<RoleDto> from( final List<Role> roleList ) {
		final List<RoleDto> roleDto = new LinkedList<RoleDto>();
		for ( final Role role : roleList ) {
			roleDto.add( from( role ) );
		}
		return roleDto;
	}
}
