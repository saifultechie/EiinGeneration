package com.eiin.institutionEiinGenerate.controller;

import com.eiin.institutionEiinGenerate.dto.DivisionDto;
import com.eiin.institutionEiinGenerate.dto.DivisionResponse;
import com.eiin.institutionEiinGenerate.dto.EiinDto;
import com.eiin.institutionEiinGenerate.dto.EiinResponse;
import com.eiin.institutionEiinGenerate.entity.Division;
import com.eiin.institutionEiinGenerate.entity.Eiin;
import com.eiin.institutionEiinGenerate.exception.NotFoundException;
import com.eiin.institutionEiinGenerate.helper.CommonDataHelper;
import com.eiin.institutionEiinGenerate.service.DivisionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.eiin.institutionEiinGenerate.exception.ApiError.fieldError;
import static com.eiin.institutionEiinGenerate.response.ResponseBuilder.error;
import static com.eiin.institutionEiinGenerate.response.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@Api(tags = "Division Api")
public class DivisionController {
    private final DivisionService divisionService;
    private final CommonDataHelper helper;

    @PostMapping("/division/save")
    @ApiOperation(value = "save Division", response = DivisionDto.class)
    public ResponseEntity<JSONObject> save(@Valid @RequestBody DivisionDto dto, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }
        Division division  = dto.to();
        divisionService.save(division);
        return ok(success(DivisionResponse.from(division)).getJson());

    }

    @PutMapping("/division/update")
    @ApiOperation(value = "update Division", response = DivisionDto.class)
    public ResponseEntity<JSONObject> update(@RequestBody DivisionDto dto)
    {
        Division d = divisionService.findById(dto.getId()).orElseThrow(NotFoundException::new );
        dto.update(d);
        divisionService.update(d);
        return ok(success(DivisionResponse.from(d)).getJson());

    }

    @GetMapping("/division/all")
    @ApiOperation(value = "get all division", response = DivisionDto.class)
    public ResponseEntity<JSONObject> getAllEiin(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(value = "size", defaultValue = "5") Integer size)
    {
        helper.setPageSize(page, size);
        Map<String, Object> response = new HashMap<>();

        Map<String, Object> divisionMap = divisionService.getAllDivision(page, size);

        List<Division> divisions = (List<Division>) divisionMap.get("lists");

        List<DivisionDto> dtos = divisions.stream().map(DivisionDto::from).collect(Collectors.toList());

        helper.getCommonData(page, size, divisionMap, response, dtos);

        return ok(success(response).getJson());
    }
}
