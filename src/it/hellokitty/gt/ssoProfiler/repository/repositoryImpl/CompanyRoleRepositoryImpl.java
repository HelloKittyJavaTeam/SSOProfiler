package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoProfiler.entity.CompanyRole;
import it.hellokitty.gt.ssoProfiler.repository.CompanyRoleRepository;

public class CompanyRoleRepositoryImpl extends RepositoryUtils<CompanyRole> implements CompanyRoleRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = CompanyRole.class;
	}
	
	public CompanyRoleRepositoryImpl(){
		super();
	}
}
