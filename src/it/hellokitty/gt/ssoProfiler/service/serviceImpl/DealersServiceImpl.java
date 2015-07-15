package it.hellokitty.gt.ssoProfiler.service.serviceImpl;

import it.hellokitty.gt.ssoProfiler.entity.Dealers;
import it.hellokitty.gt.ssoProfiler.repository.DealersRepository;
import it.hellokitty.gt.ssoProfiler.repository.repositoryImpl.DealersRepositoryImpl;
import it.hellokitty.gt.ssoProfiler.service.DealersService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class DealersServiceImpl implements DealersService{
	DealersRepository dealersRepository = new DealersRepositoryImpl();

	public DealersServiceImpl(){
		super();
	}
	
	@Override
	public Long count() throws Exception {
		return dealersRepository.count();
	}

	@Override
	public Long count(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception {
		if(paramEquals == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramEquals parameter cannot be null.");
		}
		
		if(paramLike == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramLike parameter cannot be null.");
		}
		
		if(paramGE == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramGE parameter cannot be null.");
		}
		
		if(paramLE == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+ this.getClass()+" - paramLE parameter cannot be null.");
		}
		
		return dealersRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<Dealers> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return dealersRepository.fetchAll(start, limit, orderColumn);
	}

	@Override
	public Dealers fetchById(Object id) throws Exception {
		return dealersRepository.fetchById(id);
	}

	@Override
	public List<Dealers> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return dealersRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}

