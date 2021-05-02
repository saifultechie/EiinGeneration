package com.eiin.institutionEiinGenerate.repository;

import com.eiin.institutionEiinGenerate.entity.Eiin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EiinRepository extends JpaRepository<Eiin , Long> {
}
