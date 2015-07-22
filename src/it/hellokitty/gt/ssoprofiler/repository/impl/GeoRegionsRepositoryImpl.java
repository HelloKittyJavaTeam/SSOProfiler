package it.hellokitty.gt.ssoprofiler.repository.impl;

import it.ferrari.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.ssoprofiler.entity.GeoRegions;
import it.hellokitty.gt.ssoprofiler.repository.GeoRegionsRepository;

public class GeoRegionsRepositoryImpl extends RepositoryUtilsExt<GeoRegions> implements GeoRegionsRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = GeoRegions.class;
	}
	
	public GeoRegionsRepositoryImpl(){
		super();
	}
}
