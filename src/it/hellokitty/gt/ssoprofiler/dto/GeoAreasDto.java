package it.hellokitty.gt.ssoprofiler.dto;

import it.hellokitty.gt.ssoprofiler.entity.GeoAreas;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The DTO class of GeoAreas entity 
 *
 */
public class GeoAreasDto implements Serializable {
	private static final long serialVersionUID = -8579285349592700230L;

	private String id;
	
	private String descriptionIt;
	
	private String descriptionEn;
	
	private String descriptionFr;
	
	private String descriptionDe;
	
	private String descriptionEs;
	
	private String descriptionZh;
	
	private String descriptionJp;

	private Date dateIns;
	
	private Date dateMod;
	
	private String userIns;
	
	private String userMod;
	
	private String active;
	
	public GeoAreasDto(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescriptionIt() {
		return descriptionIt;
	}

	public void setDescriptionIt(String descriptionIt) {
		this.descriptionIt = descriptionIt;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getDescriptionFr() {
		return descriptionFr;
	}

	public void setDescriptionFr(String descriptionFr) {
		this.descriptionFr = descriptionFr;
	}

	public String getDescriptionDe() {
		return descriptionDe;
	}

	public void setDescriptionDe(String descriptionDe) {
		this.descriptionDe = descriptionDe;
	}

	public String getDescriptionEs() {
		return descriptionEs;
	}

	public void setDescriptionEs(String descriptionEs) {
		this.descriptionEs = descriptionEs;
	}

	public String getDescriptionZh() {
		return descriptionZh;
	}

	public void setDescriptionZh(String descriptionZh) {
		this.descriptionZh = descriptionZh;
	}

	public String getDescriptionJp() {
		return descriptionJp;
	}

	public void setDescriptionJp(String descriptionJp) {
		this.descriptionJp = descriptionJp;
	}

	public String getUserIns() {
		return userIns;
	}

	public void setUserIns(String userIns) {
		this.userIns = userIns;
	}

	public String getUserMod() {
		return userMod;
	}

	public void setUserMod(String userMod) {
		this.userMod = userMod;
	}

	public Boolean isActive() {
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
			this.active = "N";
		}
	}

	public Date getDateIns() {
		return dateIns;
	}

	public void setDateIns(Date dateIns) {
		this.dateIns = dateIns;
	}

	public Date getDateMod() {
		return dateMod;
	}

	public void setDateMod(Date dateMod) {
		this.dateMod = dateMod;
	}
	
	/**
	 * This method returns an GeoAreasDto of the geoArea input parameter
	 * 
	 * @param geoArea
	 * @return GeoAreasDto
	 */
	public static GeoAreasDto from( final GeoAreas geoArea ) {
		GeoAreasDto dto = new GeoAreasDto();	
		dto.setId(geoArea.getId());
		dto.setActive(geoArea.isActive());
		dto.setDateIns(geoArea.getDateIns());
		dto.setDateMod(geoArea.getDateMod());
		dto.setDescriptionDe(geoArea.getDescriptionDe());
		dto.setDescriptionEn(geoArea.getDescriptionEn());
		dto.setDescriptionEs(geoArea.getDescriptionEs());
		dto.setDescriptionFr(geoArea.getDescriptionFr());
		dto.setDescriptionIt(geoArea.getDescriptionIt());
		dto.setDescriptionJp(geoArea.getDescriptionJp());
		dto.setDescriptionZh(geoArea.getDescriptionZh());
		dto.setUserIns(geoArea.getUserIns());
		dto.setUserMod(geoArea.getUserMod());
		return dto;
	}
	
	/**
	 * This method returns a List of GeoAreasDto of the List of geoAreaList input parameter
	 * 
	 * @param geoAreaList List
	 * @return GeoAreasDto List
	 */
	public static List<GeoAreasDto> from( final List<GeoAreas> geoAreaList ) {
		final List<GeoAreasDto> geoAreaListDto = new LinkedList<GeoAreasDto>();
		for ( final GeoAreas geoArea : geoAreaList ) {
			geoAreaListDto.add( from( geoArea ) );
		}
		return geoAreaListDto;
	}
}
