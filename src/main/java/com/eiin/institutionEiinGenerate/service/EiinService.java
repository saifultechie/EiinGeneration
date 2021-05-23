package com.eiin.institutionEiinGenerate.service;

import com.eiin.institutionEiinGenerate.dto.EiinDto;
import com.eiin.institutionEiinGenerate.entity.Eiin;
import com.eiin.institutionEiinGenerate.repository.EiinRepository;
import com.eiin.institutionEiinGenerate.utils.PaginationParameters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.eiin.institutionEiinGenerate.utils.Constants.*;
import static com.eiin.institutionEiinGenerate.entity.Action.*;
import static com.eiin.institutionEiinGenerate.entity.ModuleName.*;

@Service
@RequiredArgsConstructor
public class EiinService {
    private final EiinRepository eiinRepository;
    private final EntityManager em;
    private final ActionLogService actionLogService;

    public Eiin save(Eiin eiin)
    {
       Eiin e = eiinRepository.save(eiin);
       actionLogService.publishActivity(SAVE,EIIN,e.getId(),EIIN_SAVE_COMMENT);
       return  e;
    }

    public Eiin update(Eiin eiin)
    {
        Eiin e = eiinRepository.save(eiin);
        actionLogService.publishActivity(UPDATE,EIIN,e.getId(),EIIN_UPDATE_COMMENT);
        return  e;
    }

    public void delete(Eiin eiin)
    {
        eiinRepository.delete(eiin);

    }
// criteria query
    public Map<String,Object> getAllEiin(Integer page,Integer size)
    {
        Map<String, Object> maps = new HashMap<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Eiin> query = cb.createQuery(Eiin.class);
        Root<Eiin> root = query.from(Eiin.class);

        query.select(root);

        TypedQuery<Eiin> tQuery = em.createQuery(query).setFirstResult(page * size).setMaxResults(size);

        List<Eiin> eiins = tQuery.getResultList();

        Long total = (long) eiins.size();

        PaginationParameters.getdata(maps, page, total, size, eiins);

        return maps;
    }
//    public List<Eiin> getAll()
//    {
//        return eiinRepository.getAllEiins();
//    }

    // query interface
//    public List<Eiin> getAllEiin()
//    {
//        String SqlQuery = "SELECT e FROM Employee";
//        Query query = em.createQuery(SqlQuery);
//        List<Eiin> eiins = query.getResultList();
//        return eiins;
//    }

    // TypedQuery interface
//    public List<Eiin> getAllEiin()
//    {
//        String SqlQuery = "SELECT e FROM Employee";
//        TypedQuery<Eiin> query = em.createQuery(SqlQuery,Eiin.class);
//        List<Eiin> eiins = query.getResultList();
//        return eiins;
//    }

    // projection dto
//    public List<EiinDto> getAllEiins()
//    {
//        String SqlQuery = "SELECT"
//                            +"new com.institutionEiinGenerate.dto.EiinDto("
//                            +"e.name"
//                            +" )"
//                            +"FROM Eiin e";
//        TypedQuery<EiinDto> query = em.createQuery(SqlQuery,EiinDto.class);
//        List<EiinDto> eiins = query.getResultList();
//        return eiins;
//    }



    public Optional<Eiin> findById(Long id) {
        return eiinRepository.findById(id);
    }
}
