package com.eiin.institutionEiinGenerate.service;

import com.eiin.institutionEiinGenerate.entity.Division;
import com.eiin.institutionEiinGenerate.repository.DivisionRepository;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DivisionService {
    private final DivisionRepository divisionRepository;
    private final EntityManager em;

    public Division save(Division division)
    {
        Division d = divisionRepository.save(division);
        return d;
    }
    public Division update(Division division)
    {
        Division d = divisionRepository.save(division);
        return d;
    }

    public Map<String,Object> getAllDivision(Integer page, Integer size)
    {
        Map<String, Object> maps = new HashMap<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Division> query = cb.createQuery(Division.class);
        Root<Division> root = query.from(Division.class);

        query.select(root);

        TypedQuery<Division> tQuery = em.createQuery(query).setFirstResult(page * size).setMaxResults(size);

        List<Division> divisions = tQuery.getResultList();

        Long total = (long) divisions.size();

        PaginationParameters.getdata(maps, page, total, size, divisions);

        return maps;
    }

    public Optional<Division> findById(Long id)
    {
        return divisionRepository.findById(id);
    }
}
