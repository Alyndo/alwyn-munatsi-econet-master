package co.zw.econet.area.service;

import co.zw.econet.area.model.Area;

import java.util.List;
import java.util.Optional;

public interface AreaService {

    Optional<Area> save(Area area);

    List<Area> findAll();

    Optional<Area> findById(Long id);

    Optional<Area> findByName(String name);
}
