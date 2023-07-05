package co.zw.econet.area.repository;

import co.zw.econet.area.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Long> {
    Optional<Area> findByName(String name);

}
