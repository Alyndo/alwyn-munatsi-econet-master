package co.zw.econet.area.controller;

import co.zw.econet.area.model.Area;
import co.zw.econet.area.service.AreaService;
import co.zw.econet.commons.GlobalRuntimeException;
import co.zw.econet.commons.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/area")
@Slf4j
@RequiredArgsConstructor
public class AreaController {

    private final AreaService service;

    @PostMapping
    public Response<Area> saveArea(@RequestBody Area area){

        log.info("Area to be saved {}", area);
        Optional<Area> optionalArea = service.save(area);
        area = optionalArea.orElseThrow(() -> new GlobalRuntimeException("Error creating invoice"));
        return new Response<>(HttpStatus.OK.value(), "Success in processing transaction", area);
    }

    @GetMapping
    public Response<List<Area>> findAllAreas(){
        List<Area> areas = service.findAll();
        return new Response<>(HttpStatus.OK.value(), "Success in processing transaction", areas);
    }

    @GetMapping("/findById/{areaId}")
    public Response<Area> findAreaById(@PathVariable("areaId") Long areaId){
        Area area = service.findById(areaId).orElseThrow(() -> new GlobalRuntimeException("Error creating invoice"));

        return new Response<>(HttpStatus.OK.value(), "Success in processing transaction", area);
    }
}
