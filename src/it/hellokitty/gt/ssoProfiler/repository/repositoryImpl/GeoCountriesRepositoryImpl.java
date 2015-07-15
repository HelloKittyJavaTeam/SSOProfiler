package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import static it.hellokitty.gt.repository.utils.RepositoryUtils.persistenceUnitName;
import it.hellokitty.gt.repository.utils.ColumnDirection;
import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoProfiler.entity.GeoCountries;
import it.hellokitty.gt.ssoProfiler.repository.GeoCountriesRepository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GeoCountriesRepositoryImpl extends RepositoryUtils<GeoCountries> implements GeoCountriesRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
	}
	
	@Override
	public List<GeoCountries> fetchAll(Integer start, Integer limit, List<ColumnDirection> cdList){
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<GeoCountries> cq = cb.createQuery(GeoCountries.class);
		Root<GeoCountries> geoCountries = cq.from(GeoCountries.class);


		cq.select(geoCountries);

		cq = order(cq, cb, geoCountries, cdList);

		TypedQuery<GeoCountries> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public GeoCountries fetchById(Long id) throws Exception {
		return getEm().find(GeoCountries.class, id);
	}

	@Override
	public List<GeoCountries> fetchAll(String user, Integer start, Integer limit, List<ColumnDirection> cdList) throws Exception {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<GeoCountries> cq = cb.createQuery(GeoCountries.class);
		Root<GeoCountries> geoCountries = cq.from(GeoCountries.class);

		if(isAdmin(user)){
			cq.where(cb.equal(geoCountries.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(geoCountries.get("userCreated"), user),
					cb.equal(geoCountries.get("active"), true)));
		}

		cq.select(geoCountries);

		cq = order(cq, cb, geoCountries, cdList);

		TypedQuery<GeoCountries> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public Long count(String user) throws Exception{
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<GeoCountries> geoCountries = cq.from(GeoCountries.class);

		if(isAdmin(user)){
			cq.where(cb.equal(geoCountries.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(geoCountries.get("userCreated"), user)),
					cb.equal(geoCountries.get("active"), "1"));
		}
		cq.select(cb.count(geoCountries));
		
		return getEm().createQuery(cq).getSingleResult();
	}
}
