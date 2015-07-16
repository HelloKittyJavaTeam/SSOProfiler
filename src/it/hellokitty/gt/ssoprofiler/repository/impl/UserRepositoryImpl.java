package it.hellokitty.gt.ssoprofiler.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoprofiler.entity.AdUsers;
import it.hellokitty.gt.ssoprofiler.repository.UserRepository;

public class UserRepositoryImpl extends RepositoryUtils<AdUsers> implements UserRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = AdUsers.class;
	}
	
	public UserRepositoryImpl() {
		super();
	}
}
