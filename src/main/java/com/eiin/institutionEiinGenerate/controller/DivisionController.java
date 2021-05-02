package com.eiin.institutionEiinGenerate.controller;

import com.eiin.institutionEiinGenerate.dto.DivisionDto;
import com.eiin.institutionEiinGenerate.dto.DivisionResponse;
import com.eiin.institutionEiinGenerate.dto.EiinResponse;
import com.eiin.institutionEiinGenerate.entity.Division;
import com.eiin.institutionEiinGenerate.service.DivisionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.eiin.institutionEiinGenerate.response.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@Api(tags = "Division Api")
public class DivisionController {
    private final DivisionService divisionService;

    @PostMapping("/division/save")
    @ApiOperation(value = "save Division", response = DivisionDto.class)
    public ResponseEntity<JSONObject> save(@RequestBody DivisionDto dto)
    {
        Division division  = dto.to();
        divisionService.save(division);
        return ok(success(DivisionResponse.from(division)).getJson());

    }
}
