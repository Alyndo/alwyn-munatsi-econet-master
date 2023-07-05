package co.zw.econet.shop.service;


import co.zw.econet.shop.model.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    Optional<Shop> save(Shop shop);

    List<Shop> findAll();

    List<Shop> findShopsByArea(String name);
}
