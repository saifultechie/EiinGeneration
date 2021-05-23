package com.eiin.institutionEiinGenerate.repository;

import com.eiin.institutionEiinGenerate.entity.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionLogRepository extends JpaRepository<ActionLog,Long> {
}
