package com.eiin.institutionEiinGenerate.dto;

import com.eiin.institutionEiinGenerate.entity.Division;
import com.eiin.institutionEiinGenerate.entity.Eiin;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
public class DivisionDto {
    private Long id;
    @NotBlank
    private String name;
    private String bn_name;
    private String url;
    private List<Eiin> eiins;

    public Division to()
    {
        Division d = new Division();
        d.setName(name);
        d.setBn_name(bn_name);
        d.setUrl(url);
        return  d ;
    }

    public static DivisionDto from(Division division) {

        DivisionDto dto = new DivisionDto();
        dto.setId(division.getId());
        dto.setName(division.getName());
        dto.setBn_name(division.getBn_name());
        dto.setUrl(division.getUrl());
        dto.setEiins(division.getEiin());
        return dto;
    }

    public void update(Division d){
        d.setName(name);
        d.setBn_name(bn_name);
        d.setUrl(url);

    }

    public DivisionDto(String name)
    {
        this.name = name;

    }
}
