package it.hellokitty.gt.ssoprofiler.repository.repositoryImpl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
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
