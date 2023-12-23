package cybergarden.EvrazCase.service;

import cybergarden.EvrazCase.DTO.CarDTO;
import cybergarden.EvrazCase.entity.CarEntity;
import cybergarden.EvrazCase.exception.car.CarNotFoundByIdException;
import cybergarden.EvrazCase.exception.company.CompanyNotFoundByIdException;
import cybergarden.EvrazCase.exception.destination.DestinationNotFoundByIdException;
import cybergarden.EvrazCase.exception.head.HeadNotFoundByIdException;
import cybergarden.EvrazCase.exception.track.TrackIsNotFreeException;
import cybergarden.EvrazCase.exception.track.TrackNotFoundByIdException;

import java.util.List;

public interface CarService {
    CarEntity createCar(CarDTO car, Long carId)
            throws  DestinationNotFoundByIdException,
                    CompanyNotFoundByIdException,
                    HeadNotFoundByIdException,
                    TrackNotFoundByIdException,
                    TrackIsNotFreeException;
    List<CarEntity> getAllCars();
    CarEntity updateCar(CarEntity car, Long carId) throws CarNotFoundByIdException;
    void deleteCar(Long carId) throws CarNotFoundByIdException;


    CarEntity getCar(Long carId) throws CarNotFoundByIdException;
}
