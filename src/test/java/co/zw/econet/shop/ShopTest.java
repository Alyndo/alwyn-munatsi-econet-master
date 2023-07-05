package co.zw.econet.shop;

import co.zw.econet.area.model.Area;
import co.zw.econet.area.service.AreaService;
import co.zw.econet.shop.model.Shop;
import co.zw.econet.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@RequiredArgsConstructor
public class ShopTest {

    private final AreaService areaService;
    private final ShopService shopService;

    @Test
    public void saveShop(){
        Area area = areaService.findById(1L).get();
        Shop shop = new Shop();
        shop.setName("Econet Shop");
        shop.setArea(area);
        var shopToSave = shopService.save(shop);
        assertNotNull(shopToSave);
    }
}
