package com.eiin.institutionEiinGenerate.dto;

import com.eiin.institutionEiinGenerate.entity.District;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DistrictResponse {
    private Long id;
    private String name;
    private String bn_name;
    private String url;
    private String lat;
    private String lon;
    private String division;

    public  static DistrictResponse from (District district)
    {
        DistrictResponse dto = new DistrictResponse();
        dto.setId(district.getId());
        dto.setName(district.getName());
        dto.setBn_name(district.getBn_name());
        dto.setUrl(district.getUrl());
        dto.setLat(district.getLat());
        dto.setLon(district.getLon());
        dto.setDivision(district.getDivision().getName());
        return dto;

    }
}
