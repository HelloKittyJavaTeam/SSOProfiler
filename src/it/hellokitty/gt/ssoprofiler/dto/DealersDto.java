package it.hellokitty.gt.ssoprofiler.dto;

import it.hellokitty.gt.ssoprofiler.entity.Dealers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The DTO class of Dealers entity 
 *
 */
public class DealersDto implements Serializable {
	private static final long serialVersionUID = -9223143478607955426L;

	private String id;
	
	private String active;

	private String address;

	private String city;

	private String complement;

	private Date dateIns;

	private Date dateMod;

	private String dealerType;

	private String email;

	private String fax;

	private String flagAftermarket;

	private String flagAlluminium;

	private String flagAssistance;

	private String flagBodyshop;

	private String flagDealer;

	private String flagDealerselection;

	private String flagEuropeass;

	private String flagFlagship;

	private String flagHvr;

	private String flagImporter;

	private String flagPdicenter;

	private String flagPos;

	private String flagRegionaloffice;

	private String flagRegionalofficeSubsidiary;

	private String flagShowroom;

	private String flagSubdealer;

	private String flagSubsidiary;

	private BigDecimal glLatitude;

	private BigDecimal glLongitude;

	private String houseNumber;

	private String name;

	private String phone;

	private String province;

	private String provinceCode;

	private String swEnabled;

	private BigDecimal swHeading;

	private BigDecimal swLatitude;

	private BigDecimal swLongitude;

	private BigDecimal swPitch;

	private BigDecimal swZoom;

	private String userIns;

	private String userMod;

	private String village;

	private String website;

	private String zipcode;

	public DealersDto() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
			this.active = "N";
		}
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComplement() {
		return this.complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Date getDateIns() {
		return this.dateIns;
	}

	public void setDateIns(Date dateIns) {
		this.dateIns = dateIns;
	}

	public Date getDateMod() {
		return this.dateMod;
	}

	public void setDateMod(Date dateMod) {
		this.dateMod = dateMod;
	}

	public String getDealerType() {
		return this.dealerType;
	}

	public void setDealerType(String dealerType) {
		this.dealerType = dealerType;
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

	public String getFlagAftermarket() {
		return this.flagAftermarket;
	}

	public void setFlagAftermarket(String flagAftermarket) {
		this.flagAftermarket = flagAftermarket;
	}

	public String getFlagAlluminium() {
		return this.flagAlluminium;
	}

	public void setFlagAlluminium(String flagAlluminium) {
		this.flagAlluminium = flagAlluminium;
	}

	public String getFlagAssistance() {
		return this.flagAssistance;
	}

	public void setFlagAssistance(String flagAssistance) {
		this.flagAssistance = flagAssistance;
	}

	public String getFlagBodyshop() {
		return this.flagBodyshop;
	}

	public void setFlagBodyshop(String flagBodyshop) {
		this.flagBodyshop = flagBodyshop;
	}

	public String getFlagDealer() {
		return this.flagDealer;
	}

	public void setFlagDealer(String flagDealer) {
		this.flagDealer = flagDealer;
	}

	public String getFlagDealerselection() {
		return this.flagDealerselection;
	}

	public void setFlagDealerselection(String flagDealerselection) {
		this.flagDealerselection = flagDealerselection;
	}

	public String getFlagEuropeass() {
		return this.flagEuropeass;
	}

	public void setFlagEuropeass(String flagEuropeass) {
		this.flagEuropeass = flagEuropeass;
	}

	public String getFlagFlagship() {
		return this.flagFlagship;
	}

	public void setFlagFlagship(String flagFlagship) {
		this.flagFlagship = flagFlagship;
	}

	public String getFlagHvr() {
		return this.flagHvr;
	}

	public void setFlagHvr(String flagHvr) {
		this.flagHvr = flagHvr;
	}

	public String getFlagImporter() {
		return this.flagImporter;
	}

	public void setFlagImporter(String flagImporter) {
		this.flagImporter = flagImporter;
	}

	public String getFlagPdicenter() {
		return this.flagPdicenter;
	}

	public void setFlagPdicenter(String flagPdicenter) {
		this.flagPdicenter = flagPdicenter;
	}

	public String getFlagPos() {
		return this.flagPos;
	}

	public void setFlagPos(String flagPos) {
		this.flagPos = flagPos;
	}

	public String getFlagRegionaloffice() {
		return this.flagRegionaloffice;
	}

	public void setFlagRegionaloffice(String flagRegionaloffice) {
		this.flagRegionaloffice = flagRegionaloffice;
	}

	public String getFlagRegionalofficeSubsidiary() {
		return this.flagRegionalofficeSubsidiary;
	}

	public void setFlagRegionalofficeSubsidiary(String flagRegionalofficeSubsidiary) {
		this.flagRegionalofficeSubsidiary = flagRegionalofficeSubsidiary;
	}

	public String getFlagShowroom() {
		return this.flagShowroom;
	}

	public void setFlagShowroom(String flagShowroom) {
		this.flagShowroom = flagShowroom;
	}

	public String getFlagSubdealer() {
		return this.flagSubdealer;
	}

	public void setFlagSubdealer(String flagSubdealer) {
		this.flagSubdealer = flagSubdealer;
	}

	public String getFlagSubsidiary() {
		return this.flagSubsidiary;
	}

	public void setFlagSubsidiary(String flagSubsidiary) {
		this.flagSubsidiary = flagSubsidiary;
	}

	public BigDecimal getGlLatitude() {
		return this.glLatitude;
	}

	public void setGlLatitude(BigDecimal glLatitude) {
		this.glLatitude = glLatitude;
	}

	public BigDecimal getGlLongitude() {
		return this.glLongitude;
	}

	public void setGlLongitude(BigDecimal glLongitude) {
		this.glLongitude = glLongitude;
	}

	public String getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvinceCode() {
		return this.provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getSwEnabled() {
		return this.swEnabled;
	}

	public void setSwEnabled(String swEnabled) {
		this.swEnabled = swEnabled;
	}

	public BigDecimal getSwHeading() {
		return this.swHeading;
	}

	public void setSwHeading(BigDecimal swHeading) {
		this.swHeading = swHeading;
	}

	public BigDecimal getSwLatitude() {
		return this.swLatitude;
	}

	public void setSwLatitude(BigDecimal swLatitude) {
		this.swLatitude = swLatitude;
	}

	public BigDecimal getSwLongitude() {
		return this.swLongitude;
	}

	public void setSwLongitude(BigDecimal swLongitude) {
		this.swLongitude = swLongitude;
	}

	public BigDecimal getSwPitch() {
		return this.swPitch;
	}

	public void setSwPitch(BigDecimal swPitch) {
		this.swPitch = swPitch;
	}

	public BigDecimal getSwZoom() {
		return this.swZoom;
	}

	public void setSwZoom(BigDecimal swZoom) {
		this.swZoom = swZoom;
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

	public String getVillage() {
		return this.village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * This method returns an DealersDto of the dealers input parameter
	 * 
	 * @param dealers
	 * @return DealersDto
	 */
	public static DealersDto from( final Dealers dealers ) {
		DealersDto dto = new DealersDto();	
		dto.setId(dealers.getId());
		dto.setAddress(dealers.getAddress());
		dto.setActive(dealers.isActive());
		dto.setCity(dealers.getCity());
		dto.setComplement(dealers.getComplement());
		dto.setDateIns(dealers.getDateIns());
		dto.setDateMod(dealers.getDateMod());
		dto.setDealerType(dealers.getDealerType());
		dto.setEmail(dealers.getEmail());
		dto.setFax(dealers.getFax());
		dto.setFlagAftermarket(dealers.getFlagAftermarket());
		dto.setFlagAlluminium(dealers.getFlagAlluminium());
		dto.setFlagAssistance(dealers.getFlagAssistance());
		dto.setFlagBodyshop(dealers.getFlagBodyshop());
		dto.setFlagDealer(dealers.getFlagDealer());
		dto.setFlagDealerselection(dealers.getFlagDealerselection());
		dto.setFlagEuropeass(dealers.getFlagEuropeass());
		dto.setFlagFlagship(dealers.getFlagFlagship());
		dto.setFlagHvr(dealers.getFlagHvr());
		dto.setFlagImporter(dealers.getFlagImporter());
		dto.setFlagPdicenter(dealers.getFlagPdicenter());
		dto.setFlagPos(dealers.getFlagPos());
		dto.setFlagRegionaloffice(dealers.getFlagRegionaloffice());
		dto.setFlagRegionalofficeSubsidiary(dealers.getFlagRegionalofficeSubsidiary());
		dto.setFlagShowroom(dealers.getFlagShowroom());
		dto.setFlagSubdealer(dealers.getFlagSubdealer());
		dto.setFlagSubsidiary(dealers.getFlagSubsidiary());
		dto.setGlLatitude(dealers.getGlLatitude());
		dto.setGlLongitude(dealers.getGlLongitude());
		dto.setHouseNumber(dealers.getHouseNumber());
		dto.setName(dealers.getName());
		dto.setPhone(dealers.getPhone());
		dto.setProvince(dealers.getProvince());
		dto.setProvinceCode(dealers.getProvinceCode());
		dto.setSwEnabled(dealers.getSwEnabled());
		dto.setSwHeading(dealers.getSwHeading());
		dto.setSwLatitude(dealers.getSwLatitude());
		dto.setSwLongitude(dealers.getSwLongitude());
		dto.setSwPitch(dealers.getSwPitch());
		dto.setSwZoom(dealers.getSwZoom());
		dto.setUserIns(dealers.getUserIns());
		dto.setUserMod(dealers.getUserMod());
		dto.setVillage(dealers.getVillage());
		dto.setWebsite(dealers.getWebsite());
		dto.setZipcode(dealers.getZipcode());

		return dto;
	}
	
	/**
	 * This method returns a List of DealersDto of the List of dealerList input parameter
	 * 
	 * @param dealerList List
	 * @return DealersDto List
	 */
	public static List<DealersDto> from( final List<Dealers> dealerList ) {
		final List<DealersDto> dealersListDto = new LinkedList<DealersDto>();
		for ( final Dealers dealer : dealerList ) {
			dealersListDto.add( from( dealer ) );
		}
		return dealersListDto;
	}

}
