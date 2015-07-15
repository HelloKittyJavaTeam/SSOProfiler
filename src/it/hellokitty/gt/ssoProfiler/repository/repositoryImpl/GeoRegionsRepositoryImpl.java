package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import static it.hellokitty.gt.repository.utils.RepositoryUtils.persistenceUnitName;
import it.hellokitty.gt.repository.utils.ColumnDirection;
import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoProfiler.entity.GeoRegions;
import it.hellokitty.gt.ssoProfiler.repository.GeoRegionsRepository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GeoRegionsRepositoryImpl extends RepositoryUtils<GeoRegions> implements GeoRegionsRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
	}
	
	@Override
	public List<GeoRegions> fetchAll(Integer start, Integer limit, List<ColumnDirection> cdList){
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<GeoRegions> cq = cb.createQuery(GeoRegions.class);
		Root<GeoRegions> geoRegions = cq.from(GeoRegions.class);


		cq.select(geoRegions);

		cq = order(cq, cb, geoRegions, cdList);

		TypedQuery<GeoRegions> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public GeoRegions fetchById(Long id) throws Exception {
		return getEm().find(GeoRegions.class, id);
	}

	@Override
	public List<GeoRegions> fetchAll(String user, Integer start, Integer limit, List<ColumnDirection> cdList) throws Exception {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<GeoRegions> cq = cb.createQuery(GeoRegions.class);
		Root<GeoRegions> geoRegions = cq.from(GeoRegions.class);

		if(isAdmin(user)){
			cq.where(cb.equal(geoRegions.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(geoRegions.get("userCreated"), user),
					cb.equal(geoRegions.get("active"), true)));
		}

		cq.select(geoRegions);

		cq = order(cq, cb, geoRegions, cdList);

		TypedQuery<GeoRegions> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public Long count(String user) throws Exception{
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<GeoRegions> geoRegions = cq.from(GeoRegions.class);

		if(isAdmin(user)){
			cq.where(cb.equal(geoRegions.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(geoRegions.get("userCreated"), user)),
					cb.equal(geoRegions.get("active"), "1"));
		}
		cq.select(cb.count(geoRegions));
		
		return getEm().createQuery(cq).getSingleResult();
	}
}
