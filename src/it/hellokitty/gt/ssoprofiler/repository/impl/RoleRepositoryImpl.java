package it.hellokitty.gt.ssoprofiler.repository.impl;

import it.ferrari.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoprofiler.entity.Role;
import it.hellokitty.gt.ssoprofiler.repository.RoleRepository;

public class RoleRepositoryImpl extends RepositoryUtils<Role> implements RoleRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = Role.class;
	}
	
	public RoleRepositoryImpl() {
		super();
	}
}
