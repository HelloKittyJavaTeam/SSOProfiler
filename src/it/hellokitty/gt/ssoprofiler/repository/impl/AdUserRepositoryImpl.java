package it.hellokitty.gt.ssoprofiler.repository.impl;

import it.ferrari.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoprofiler.entity.AdUsers;
import it.hellokitty.gt.ssoprofiler.repository.AdUserRepository;

public class AdUserRepositoryImpl extends RepositoryUtils<AdUsers> implements AdUserRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = AdUsers.class;
	}
	
	public AdUserRepositoryImpl() {
		super();
	}
}
