package it.hellokitty.gt.ssoprofiler.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.ssoprofiler.entity.GeoCountries;
import it.hellokitty.gt.ssoprofiler.repository.GeoCountriesRepository;

public class GeoCountriesRepositoryImpl extends RepositoryUtilsExt<GeoCountries> implements GeoCountriesRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = GeoCountries.class;
	}
	
	public GeoCountriesRepositoryImpl(){
		super();
	}
}
