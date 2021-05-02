package com.eiin.institutionEiinGenerate.service;

import com.eiin.institutionEiinGenerate.entity.Division;
import com.eiin.institutionEiinGenerate.repository.DivisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DivisionService {
    private final DivisionRepository divisionRepository;

    public Division save(Division division)
    {
        Division d = divisionRepository.save(division);
        return d;
    }
}
