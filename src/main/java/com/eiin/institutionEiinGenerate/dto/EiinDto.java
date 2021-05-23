package com.eiin.institutionEiinGenerate.dto;

import com.eiin.institutionEiinGenerate.entity.Eiin;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class EiinDto {
    private  Long id;
    @NotBlank
    private String name;
    public Eiin to()
    {
        Eiin eiin = new Eiin();
        eiin.setName(name);
        return  eiin;
    }
    public static EiinDto from(Eiin e) {

        EiinDto dto = new EiinDto();
        dto.setId(e.getId());
        dto.setName(e.getName());
        return dto;
    }
    public void update(Eiin e){
        e.setName(name);
    }

    public EiinDto(String name){
        this.name=name;
    }

}
