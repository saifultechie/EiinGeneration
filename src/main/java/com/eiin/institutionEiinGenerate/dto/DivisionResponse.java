package com.eiin.institutionEiinGenerate.dto;

import com.eiin.institutionEiinGenerate.entity.Division;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DivisionResponse {
    private Long id;
    private String name;
    private String bn_name;
    private String url;

    public static DivisionResponse from(Division division)
    {
        DivisionResponse dto = new DivisionResponse();
        dto.setName(division.getName());
        dto.setBn_name(division.getBn_name());
        dto.setUrl(division.getUrl());
        dto.setId(division.getId());
        return dto;
    }
}
