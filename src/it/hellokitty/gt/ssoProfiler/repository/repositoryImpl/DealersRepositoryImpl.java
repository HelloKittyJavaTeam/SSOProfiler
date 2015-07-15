package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoProfiler.entity.Dealers;
import it.hellokitty.gt.ssoProfiler.repository.DealersRepository;

public class DealersRepositoryImpl extends RepositoryUtils<Dealers> implements DealersRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = Dealers.class;
	}
	
	public DealersRepositoryImpl(){
		super();
	}
}
