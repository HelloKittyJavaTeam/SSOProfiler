package it.hellokitty.gt.ssoprofiler.dto;

import it.hellokitty.gt.ssoprofiler.entity.Application;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *  The DTO class for Application entity
 *
 */
public class ApplicationDto implements Serializable{
	private static final long serialVersionUID = 6076925112555746898L;

	private long id;
	
	private String name;
	
	public ApplicationDto(){}

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
	 * This method returns an ApplicationDto of the application input parameter
	 * 
	 * @param application
	 * @return ApplicationDto
	 */
	public static ApplicationDto from( final Application application ) {
		ApplicationDto dto = new ApplicationDto();

		dto.setId(application.getId());
		dto.setName(application.getName());
		
		return dto;
	}
	
	/**
	 * This method returns a List of ApplicationDto of the List of applicationList input parameter
	 * 
	 * @param applicationList List
	 * @return List of ApplicationDto
	 */
	public static List<ApplicationDto> from( final List<Application> applicationList ) {
		final List<ApplicationDto> applicationDto = new LinkedList<ApplicationDto>();
		for ( final Application application : applicationList ) {
			applicationDto.add( from( application ) );
		}
		return applicationDto;
	}
}
