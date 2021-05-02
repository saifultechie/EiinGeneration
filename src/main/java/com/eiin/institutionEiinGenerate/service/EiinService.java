package com.eiin.institutionEiinGenerate.service;

import com.eiin.institutionEiinGenerate.entity.Eiin;
import com.eiin.institutionEiinGenerate.repository.EiinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EiinService {
    private final EiinRepository eiinRepository;

    public Eiin save(Eiin eiin)
    {
       Eiin e = eiinRepository.save(eiin);
       return  e;
    }
}
