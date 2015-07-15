package it.hellokitty.gt.ssoprofiler.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.ssoprofiler.entity.Dealers;
import it.hellokitty.gt.ssoprofiler.repository.DealersRepository;

public class DealersRepositoryImpl extends RepositoryUtilsExt<Dealers> implements DealersRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = Dealers.class;
	}
	
	public DealersRepositoryImpl(){
		super();
	}
}
