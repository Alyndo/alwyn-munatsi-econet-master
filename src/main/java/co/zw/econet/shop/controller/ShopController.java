package co.zw.econet.shop.controller;

import co.zw.econet.area.repository.AreaRepository;
import co.zw.econet.commons.GlobalRuntimeException;
import co.zw.econet.commons.Response;
import co.zw.econet.shop.model.Shop;
import co.zw.econet.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;
    private final AreaRepository areaRepository;

    @PostMapping("/{areaId}/save")
    public Response<Shop> saveShop(@PathVariable("areaId") Long areaId, @RequestBody Shop shop){
        var area = areaRepository.findById(areaId).orElseThrow(() -> new GlobalRuntimeException("Area not found"));
        shop.setArea(area);
        shop.setName(shop.getName().toUpperCase());
        Optional<Shop> optionalShop = shopService.save(shop);
        shop = optionalShop.orElseThrow(() -> new GlobalRuntimeException("Error creating invoice"));
        return new Response<>(HttpStatus.OK.value(), "Success in processing transaction", shop);
    }

    @GetMapping
    public Response<List<Shop>> findAllShops(){

        List<Shop> shops = shopService.findAll();
        return new Response<>(HttpStatus.OK.value(), "Success in processing transaction", shops);
    }

    @GetMapping("/{name}")
    public Response<List<Shop>> findShopsByAreaName(@PathVariable("name") String name){

        List<Shop> shops = shopService.findShopsByArea(name);
        return new Response<>(HttpStatus.OK.value(), "Success in processing transaction", shops);
    }
}
