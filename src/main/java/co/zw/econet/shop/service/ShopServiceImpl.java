package co.zw.econet.shop.service;

import co.zw.econet.area.service.AreaService;
import co.zw.econet.commons.GlobalRuntimeException;
import co.zw.econet.shop.model.Shop;
import co.zw.econet.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService{

    private final ShopRepository shopRepository;
    private final AreaService areaService;

    @Override
    public Optional<Shop> save(Shop shop) {
        return Optional.ofNullable(shopRepository.save(shop));
    }

    @Override
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Override
    public List<Shop> findShopsByArea(String area) {
        var byArea = areaService.findByName(area);

        if(byArea.isPresent())
            return shopRepository.findByAreaName(area);

        throw new GlobalRuntimeException("Area name" + area + " not Found");
    }
}
