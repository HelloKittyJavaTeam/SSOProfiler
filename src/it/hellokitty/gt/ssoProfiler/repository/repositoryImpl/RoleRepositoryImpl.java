package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoProfiler.entity.Role;
import it.hellokitty.gt.ssoProfiler.repository.RoleRepository;

public class RoleRepositoryImpl extends RepositoryUtils<Role> implements RoleRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = Role.class;
	}
	
	public RoleRepositoryImpl() {
		super();
	}
}
