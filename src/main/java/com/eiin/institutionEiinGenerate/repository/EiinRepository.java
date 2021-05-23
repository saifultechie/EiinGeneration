package com.eiin.institutionEiinGenerate.repository;

import com.eiin.institutionEiinGenerate.entity.Eiin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EiinRepository extends JpaRepository<Eiin , Long> {
    //Spring orm native query
//    @Query(value = "Select * from eiin",nativeQuery = true)
//    List<Eiin> getAllEiins();
    //Spring database depend qury
//    @Query(value = "Select e from Eiin e")
//    List<Eiin> getAllEiins();
// projection query in spring orm
//    @Query(value = "Select new com.institutionEiinGenerate.dto.EiinDto(e.name) from Eiin e")
//    List<Eiin> getAllEiins();
}
