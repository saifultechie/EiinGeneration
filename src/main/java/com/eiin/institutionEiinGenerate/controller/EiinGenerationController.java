package com.eiin.institutionEiinGenerate.controller;
import com.eiin.institutionEiinGenerate.dto.EiinResponse;
import static com.eiin.institutionEiinGenerate.response.ResponseBuilder.success;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONObject;
import com.eiin.institutionEiinGenerate.dto.EiinDto;
import com.eiin.institutionEiinGenerate.entity.Eiin;
import com.eiin.institutionEiinGenerate.service.EiinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@Api(tags = "Eiin Api")
@RequiredArgsConstructor
public class EiinGenerationController {
    private final EiinService eiinService;

    @PostMapping("/eiin/save")
    @ApiOperation(value = "save eiin", response = EiinDto.class)
    public ResponseEntity<JSONObject> save(@RequestBody EiinDto eiinDto)
    {
        Eiin eiin = eiinDto.to();
        eiinService.save(eiin);
        return ok(success(EiinResponse.from(eiin)).getJson());
    }

    @GetMapping("/home")
    public String home()
    {
        return "ok saiful";
    }
}
