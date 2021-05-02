package com.eiin.institutionEiinGenerate.dto;
import com.eiin.institutionEiinGenerate.entity.Eiin;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EiinResponse {
    private Long id;
    private String name;

    public static EiinResponse from(Eiin eiin)
    {
        EiinResponse dto = new EiinResponse();
        dto.setId(eiin.getId());
        dto.setName(eiin.getName());
        return dto;
    }

}

