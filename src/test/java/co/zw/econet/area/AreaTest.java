package co.zw.econet.area;

import co.zw.econet.area.model.Area;
import co.zw.econet.area.repository.AreaRepository;
import co.zw.econet.area.service.AreaService;
import co.zw.econet.commons.GlobalRuntimeException;
import co.zw.econet.shop.model.Shop;
import co.zw.econet.shop.repository.ShopRepository;
import co.zw.econet.shop.service.ShopService;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@AllArgsConstructor
public class AreaTest {

    private final AreaService areaService;
    private final ShopService shopService;
    private final ShopRepository shopRepository;
    private final AreaRepository areaRepository;

    @Test
    public void findAreaAndShops(){
        Long id = 1L;
        var area = areaService.findById(id);
        assertFalse(area.isEmpty());
    }

    @Test
    public void saveShopNameExist() {
        Area area = areaService.findById(1L).get();
        Shop shop = new Shop();
        shop.setName("EconetShop");
        shop.setArea(area);
        List<String> shops = shopService.findAll().stream().map(Shop::getName).toList();

        var exists = shops.contains(shop.getName());

        if (exists) {
            throw new GlobalRuntimeException("Name Already Exists");
        } else {
            var shopToSave = shopService.save(shop);
            assertNotNull(shopToSave);
        }
    }
}
