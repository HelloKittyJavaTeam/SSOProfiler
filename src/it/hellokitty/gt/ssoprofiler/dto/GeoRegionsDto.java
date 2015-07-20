package it.hellokitty.gt.ssoprofiler.dto;

import it.hellokitty.gt.ssoprofiler.entity.GeoRegions;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The DTO class of GeoRegions entity 
 *
 */
public class GeoRegionsDto implements Serializable {
	private static final long serialVersionUID = 4224899200168029580L;

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
	
	public GeoRegionsDto(){}

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
	
	/**
	 * This method returns an GeoRegionsDto of the geoRegion input parameter
	 * 
	 * @param geoRegion
	 * @return GeoRegionsDto
	 */
	public static GeoRegionsDto from( final GeoRegions geoRegion ) {
		GeoRegionsDto dto = new GeoRegionsDto();	
		dto.setId(geoRegion.getId());
		dto.setActive(geoRegion.isActive());
		dto.setDateIns(geoRegion.getDateIns());
		dto.setDateMod(geoRegion.getDateMod());
		dto.setDescriptionDe(geoRegion.getDescriptionDe());
		dto.setDescriptionEn(geoRegion.getDescriptionEn());
		dto.setDescriptionEs(geoRegion.getDescriptionEs());
		dto.setDescriptionFr(geoRegion.getDescriptionFr());
		dto.setDescriptionIt(geoRegion.getDescriptionIt());
		dto.setDescriptionJp(geoRegion.getDescriptionJp());
		dto.setDescriptionZh(geoRegion.getDescriptionZh());
		dto.setUserIns(geoRegion.getUserIns());
		dto.setUserMod(geoRegion.getUserMod());
		return dto;
	}
	
	/**
	 * This method returns a List of GeoRegionsDto of the List of geoRegionList input parameter
	 * 
	 * @param geoRegionList List
	 * @return GeoRegionsDto List
	 */
	public static List<GeoRegionsDto> from( final List<GeoRegions> geoRegionList ) {
		final List<GeoRegionsDto> geoRegionListDto = new LinkedList<GeoRegionsDto>();
		for ( final GeoRegions geoRegion : geoRegionList ) {
			geoRegionListDto.add( from( geoRegion ) );
		}
		return geoRegionListDto;
	}
}
