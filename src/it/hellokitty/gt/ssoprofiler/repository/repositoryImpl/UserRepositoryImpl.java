package it.hellokitty.gt.ssoprofiler.repository.repositoryImpl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoprofiler.entity.User;
import it.hellokitty.gt.ssoprofiler.repository.UserRepository;

public class UserRepositoryImpl extends RepositoryUtils<User> implements UserRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
		typeParameterClass = User.class;
	}
	
	public UserRepositoryImpl() {
		super();
	}
}
