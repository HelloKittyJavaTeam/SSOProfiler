package it.hellokitty.gt.ssoprofiler.repository.repositoryImpl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoprofiler.entity.Application;
import it.hellokitty.gt.ssoprofiler.repository.ApplicationRepository;

public class ApplicationRepositoryImpl extends RepositoryUtils<Application> implements ApplicationRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = Application.class;
	}
	
	public ApplicationRepositoryImpl(){
		super();
	}
}
