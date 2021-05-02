package com.eiin.institutionEiinGenerate.repository;

import com.eiin.institutionEiinGenerate.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division,Long> {
}
