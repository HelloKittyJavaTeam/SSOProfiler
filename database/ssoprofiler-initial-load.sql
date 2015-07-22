insert into sa_modiscs.geo_areas (ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
USER_INS,
USER_MOD)
select ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
USER_INS,
USER_MOD from intdms.geo_areas;
commit;

insert into sa_modiscs.geo_regions(ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
ID_AREA,
USER_INS,
USER_MOD)
select ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
ID_AREA,
USER_INS,
USER_MOD from intdms.geo_regions;
commit;

insert into sa_modiscs.geo_countries(ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
ID_ISO3166,
ID_ISO3166_3,
ID_REGION,
USER_INS,
USER_MOD)
select ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
ID_ISO3166,
ID_ISO3166_3,
ID_REGION,
USER_INS,
USER_MOD from intdms.geo_countries;
commit;

insert into sa_modiscs.dealers(ACTIVE,
ADDRESS,
CITY,
COMPLEMENT,
COUNTRY_CODE,
DATE_INS,
DATE_MOD,
DEALER_TYPE,
EMAIL,
FAX,
FLAG_AFTERMARKET,
FLAG_ALLUMINIUM,
FLAG_ASSISTANCE,
FLAG_BODYSHOP,
FLAG_DEALER,
FLAG_DEALERSELECTION,
FLAG_EUROPEASS,
FLAG_FLAGSHIP,
FLAG_HVR,
FLAG_IMPORTER,
FLAG_PDICENTER,
FLAG_POS,
FLAG_REGIONALOFFICE,
FLAG_REGIONALOFFICE_SUBSIDIARY,
FLAG_SHOWROOM,
FLAG_SUBDEALER,
FLAG_SUBSIDIARY,
GL_LATITUDE,
GL_LONGITUDE,
HOUSE_NUMBER,
ID,
NAME,
PHONE,
PROVINCE,
PROVINCE_CODE,
SW_ENABLED,
SW_HEADING,
SW_LATITUDE,
SW_LONGITUDE,
SW_PITCH,
SW_ZOOM,
USER_INS,
USER_MOD,
VILLAGE,
WEBSITE,
ZIPCODE)
select ACTIVE,
ADDRESS,
CITY,
COMPLEMENT,
COUNTRY_CODE,
DATE_INS,
DATE_MOD,
DEALER_TYPE,
EMAIL,
FAX,
FLAG_AFTERMARKET,
FLAG_ALLUMINIUM,
FLAG_ASSISTANCE,
FLAG_BODYSHOP,
FLAG_DEALER,
FLAG_DEALERSELECTION,
FLAG_EUROPEASS,
FLAG_FLAGSHIP,
FLAG_HVR,
FLAG_IMPORTER,
FLAG_PDICENTER,
FLAG_POS,
FLAG_REGIONALOFFICE,
FLAG_REGIONALOFFICE_SUBSIDIARY,
FLAG_SHOWROOM,
FLAG_SUBDEALER,
FLAG_SUBSIDIARY,
GL_LATITUDE,
GL_LONGITUDE,
HOUSE_NUMBER,
ID,
NAME,
PHONE,
PROVINCE,
PROVINCE_CODE,
SW_ENABLED,
SW_HEADING,
SW_LATITUDE,
SW_LONGITUDE,
SW_PITCH,
SW_ZOOM,
USER_INS,
USER_MOD,
VILLAGE,
WEBSITE,
ZIPCODE from intdms.dealers;
commit;