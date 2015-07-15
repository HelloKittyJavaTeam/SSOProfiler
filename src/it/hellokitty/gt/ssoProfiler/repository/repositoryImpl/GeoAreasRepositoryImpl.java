package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.ssoProfiler.entity.GeoAreas;
import it.hellokitty.gt.ssoProfiler.repository.GeoAreasRepository;

public class GeoAreasRepositoryImpl extends RepositoryUtilsExt<GeoAreas> implements GeoAreasRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = GeoAreas.class;
	}
	
	public GeoAreasRepositoryImpl(){
		super();
	}
}
