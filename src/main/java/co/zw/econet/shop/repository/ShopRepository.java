package co.zw.econet.shop.repository;

import co.zw.econet.shop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findByAreaName(String area);
}
