package com.eiin.institutionEiinGenerate.controller;

import com.eiin.institutionEiinGenerate.dto.DistrictDto;
import com.eiin.institutionEiinGenerate.dto.DistrictResponse;
import com.eiin.institutionEiinGenerate.dto.DivisionDto;
import com.eiin.institutionEiinGenerate.dto.DivisionResponse;
import com.eiin.institutionEiinGenerate.entity.District;
import com.eiin.institutionEiinGenerate.entity.Division;
import com.eiin.institutionEiinGenerate.exception.NotFoundException;
import com.eiin.institutionEiinGenerate.helper.CommonDataHelper;
import com.eiin.institutionEiinGenerate.service.DistrictService;
import com.eiin.institutionEiinGenerate.service.DivisionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.eiin.institutionEiinGenerate.response.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@Api(tags = "District Api")
public class DistrictController {

    private  final DistrictService service;
    private final DivisionService divisionService;
    private final CommonDataHelper helper;

    @PostMapping("/district/save")
    @ApiOperation(value = "save District", response = DistrictDto.class)
    public ResponseEntity<JSONObject> save(@RequestBody DistrictDto dto)
    {
        District district = dto.to();
        Division division =
                divisionService.findById(dto.getDivision()).orElseThrow(NotFoundException::new);
        district.setDivision(division);
        service.save(district);
        return ok(success(DistrictResponse.from(district)).getJson());

    }

    @GetMapping("/all/districts")
    @ApiOperation(value = "get all district", response = DistrictDto.class)
    public ResponseEntity<JSONObject> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                              @RequestParam(value = "size", defaultValue = "5") Integer size) {

        helper.setPageSize(page, size);

        Map<String, Object> response = new HashMap<>();

        Map<String, Object> districtMap = service.getAllDistricts(page, size);

        List<District> districts = (List<District>) districtMap.get("lists");

        List<DistrictDto> dtos = districts.stream().map(DistrictDto::from).collect(Collectors.toList());

        helper.getCommonData(page, size, districtMap, response, dtos);

        return ok(success(response).getJson());
    }



}
