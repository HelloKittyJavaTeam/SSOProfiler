package it.hellokitty.gt.ssoprofiler.repository.impl;

import it.ferrari.gt.repository.utils.RepositoryUtilsExt;
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
