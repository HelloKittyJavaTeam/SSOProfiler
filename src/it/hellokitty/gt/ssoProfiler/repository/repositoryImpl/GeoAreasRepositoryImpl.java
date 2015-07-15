package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import static it.hellokitty.gt.repository.utils.RepositoryUtils.persistenceUnitName;
import it.hellokitty.gt.repository.utils.ColumnDirection;
import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoProfiler.entity.GeoAreas;
import it.hellokitty.gt.ssoProfiler.repository.GeoAreasRepository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GeoAreasRepositoryImpl extends RepositoryUtils<GeoAreas> implements GeoAreasRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
	}
	
	@Override
	public List<GeoAreas> fetchAll(Integer start, Integer limit, List<ColumnDirection> cdList){
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<GeoAreas> cq = cb.createQuery(GeoAreas.class);
		Root<GeoAreas> geoArea = cq.from(GeoAreas.class);


		cq.select(geoArea);

		cq = order(cq, cb, geoArea, cdList);

		TypedQuery<GeoAreas> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public GeoAreas fetchById(Long id) throws Exception {
		return getEm().find(GeoAreas.class, id);
	}

	@Override
	public List<GeoAreas> fetchAll(String user, Integer start, Integer limit, List<ColumnDirection> cdList) throws Exception {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<GeoAreas> cq = cb.createQuery(GeoAreas.class);
		Root<GeoAreas> geoArea = cq.from(GeoAreas.class);

		if(isAdmin(user)){
			cq.where(cb.equal(geoArea.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(geoArea.get("userCreated"), user),
					cb.equal(geoArea.get("active"), true)));
		}

		cq.select(geoArea);

		cq = order(cq, cb, geoArea, cdList);

		TypedQuery<GeoAreas> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public Long count(String user) throws Exception{
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<GeoAreas> geoArea = cq.from(GeoAreas.class);

		if(isAdmin(user)){
			cq.where(cb.equal(geoArea.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(geoArea.get("userCreated"), user)),
					cb.equal(geoArea.get("active"), "1"));
		}
		cq.select(cb.count(geoArea));
		
		return getEm().createQuery(cq).getSingleResult();
	}
}
