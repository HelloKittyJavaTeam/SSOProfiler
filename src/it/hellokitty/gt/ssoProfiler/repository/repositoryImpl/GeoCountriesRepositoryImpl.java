package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.ssoProfiler.entity.GeoCountries;
import it.hellokitty.gt.ssoProfiler.repository.GeoCountriesRepository;

public class GeoCountriesRepositoryImpl extends RepositoryUtilsExt<GeoCountries> implements GeoCountriesRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = GeoCountries.class;
	}
	
	public GeoCountriesRepositoryImpl(){
		super();
	}
}
