package com.eiin.institutionEiinGenerate.dto;

import com.eiin.institutionEiinGenerate.entity.District;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DistrictDto {
    private Long id;
    private String name;
    private String bn_name;
    private String url;
    private String lat;
    private String lon;
    private Long division;

    public District to()
    {
        District d = new District();
        d.setName(name);
        d.setBn_name(bn_name);
        d.setLat(lat);
        d.setLon(lon);
        d.setUrl(url);
        return  d ;
    }

    public static DistrictDto from(District district)
    {
        DistrictDto dto = new DistrictDto();
        dto.setId(district.getId());
        dto.setName(district.getName());
        dto.setBn_name(district.getBn_name());
        dto.setUrl(district.getUrl());
        dto.setLat(district.getLat());
        dto.setLon(district.getLon());
        dto.setDivision(district.getDivision().getId());
        return dto;

    }
}
