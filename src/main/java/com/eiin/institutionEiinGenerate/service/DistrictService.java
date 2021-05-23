package com.eiin.institutionEiinGenerate.service;

import com.eiin.institutionEiinGenerate.entity.District;
import com.eiin.institutionEiinGenerate.entity.Division;
import com.eiin.institutionEiinGenerate.repository.DistrictRepository;
import com.eiin.institutionEiinGenerate.utils.PaginationParameters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepository districtRepository;
    private final EntityManager em;
    public District save(District district)
    {
        return districtRepository.save(district);
    }

    public Map<String,Object> getAllDistricts(Integer page, Integer size)
    {
        Map<String, Object> maps = new HashMap<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<District> query = cb.createQuery(District.class);
        Root<District> root = query.from(District.class);

        query.select(root);

        TypedQuery<District> tQuery = em.createQuery(query).setFirstResult(page * size).setMaxResults(size);

        List<District> districts = tQuery.getResultList();

        Long total = (long) districts.size();

        PaginationParameters.getdata(maps, page, total, size, districts);

        return maps;
    }
}
