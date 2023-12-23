package cybergarden.EvrazCase.DTO;

import cybergarden.EvrazCase.entity.CarEntity;
import cybergarden.EvrazCase.entity.WagonEntity;

import java.util.List;

public record CarWagonDTO(
        CarEntity car,
        List<WagonEntity> wagons
) {

    @Override
    public CarEntity car() {
        return car;
    }

    @Override
    public List<WagonEntity> wagons() {
        return wagons;
    }
}
