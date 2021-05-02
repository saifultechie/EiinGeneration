package com.eiin.institutionEiinGenerate.dto;

import com.eiin.institutionEiinGenerate.entity.Eiin;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EiinDto {
    private  Long id;
    private String name;

    public Eiin to()
    {
        Eiin eiin = new Eiin();
        eiin.setName(name);
        return  eiin;
    }

}
