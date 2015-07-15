package it.hellokitty.gt.ssoprofiler.repository.repositoryImpl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.ssoprofiler.entity.GeoAreas;
import it.hellokitty.gt.ssoprofiler.repository.GeoAreasRepository;

public class GeoAreasRepositoryImpl extends RepositoryUtilsExt<GeoAreas> implements GeoAreasRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = GeoAreas.class;
	}
	
	public GeoAreasRepositoryImpl(){
		super();
	}
}
