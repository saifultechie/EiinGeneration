package com.eiin.institutionEiinGenerate.controller;
import com.eiin.institutionEiinGenerate.dto.EiinResponse;
import static com.eiin.institutionEiinGenerate.response.ResponseBuilder.success;
import static com.eiin.institutionEiinGenerate.response.ResponseBuilder.error;

import com.eiin.institutionEiinGenerate.exception.NotFoundException;
import com.eiin.institutionEiinGenerate.helper.CommonDataHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONObject;
import com.eiin.institutionEiinGenerate.dto.EiinDto;
import com.eiin.institutionEiinGenerate.entity.Eiin;
import com.eiin.institutionEiinGenerate.service.EiinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;
import static com.eiin.institutionEiinGenerate.exception.ApiError.fieldError;

@RestController
@Api(tags = "Eiin Api")
@RequiredArgsConstructor
public class EiinGenerationController {
    private final EiinService eiinService;
    private final CommonDataHelper helper;

    @PostMapping("/eiin/save")
    @ApiOperation(value = "save eiin", response = EiinDto.class)
    public ResponseEntity<JSONObject> save(@Valid @RequestBody EiinDto eiinDto, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }
        Eiin eiin = eiinDto.to();
        eiinService.save(eiin);
        return ok(success(EiinResponse.from(eiin)).getJson());
    }

    @GetMapping("/eiin/all")
    @ApiOperation(value = "get all eiin", response = EiinDto.class)
    public ResponseEntity<JSONObject> getAllEiin(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(value = "size", defaultValue = "5") Integer size)
    {
        helper.setPageSize(page, size);
        Map<String, Object> response = new HashMap<>();

        Map<String, Object> eiinMap = eiinService.getAllEiin(page, size);

        List<Eiin> eiin = (List<Eiin>) eiinMap.get("lists");

        List<EiinDto> dtos = eiin.stream().map(EiinDto::from).collect(Collectors.toList());

        helper.getCommonData(page, size, eiinMap, response, dtos);

        return ok(success(response).getJson());
    }


    @PostMapping("/eiin/update")
    @ApiOperation(value = "update eiin", response = EiinDto.class)
    public ResponseEntity<JSONObject> update(@RequestBody EiinDto eiinDto)
    {
        Eiin eiin = eiinService.findById(eiinDto.getId()).orElseThrow(NotFoundException::new);
        eiinDto.update(eiin);
        eiinService.save(eiin);
        return ok(success(EiinResponse.from(eiin)).getJson());
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("delete eiin")
    public ResponseEntity<JSONObject> delete(@PathVariable Long id) {

        Eiin eiin = eiinService.findById(id).orElseThrow(NotFoundException::new);
        eiinService.delete(eiin);
        return ok(success("eiin deleted with id : " + eiin.getId()).getJson());
    }
}
