package co.zw.econet.area.service;

import co.zw.econet.area.model.Area;
import co.zw.econet.area.repository.AreaRepository;
import co.zw.econet.commons.GlobalRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService{

    private final AreaRepository areaRepository;

    @Override
    public Optional<Area> save(Area area) {
        var savedArea = areaRepository.findByName(area.getName());

        if(savedArea.isPresent())
            throw new GlobalRuntimeException("Area with name" + area.getName() + "already exists");

        return Optional.ofNullable(areaRepository.save(area));

    }

    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }

    @Override
    public Optional<Area> findById(Long id) {
        return areaRepository.findById(id);
    }

    @Override
    public Optional<Area> findByName(String name) {
        return areaRepository.findByName(name);
    }
}
