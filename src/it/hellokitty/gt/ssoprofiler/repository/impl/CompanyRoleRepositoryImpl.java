package it.hellokitty.gt.ssoprofiler.repository.impl;

import it.ferrari.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoprofiler.entity.CompanyRole;
import it.hellokitty.gt.ssoprofiler.repository.CompanyRoleRepository;

public class CompanyRoleRepositoryImpl extends RepositoryUtils<CompanyRole> implements CompanyRoleRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = CompanyRole.class;
	}
	
	public CompanyRoleRepositoryImpl(){
		super();
	}
}
