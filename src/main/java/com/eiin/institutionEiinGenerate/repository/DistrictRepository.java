package com.eiin.institutionEiinGenerate.repository;

import com.eiin.institutionEiinGenerate.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District,Long> {
}
