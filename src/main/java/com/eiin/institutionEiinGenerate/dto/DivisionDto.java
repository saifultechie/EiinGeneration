package com.eiin.institutionEiinGenerate.dto;

import com.eiin.institutionEiinGenerate.entity.Division;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DivisionDto {
    private Long id;
    private String name;
    private String bn_name;
    private String url;

    public Division to()
    {
        Division d = new Division();
        d.setName(name);
        d.setBn_name(bn_name);
        d.setUrl(url);
        return  d ;
    }
}
