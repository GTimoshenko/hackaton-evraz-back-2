package cybergarden.EvrazCase.service.impl;

import cybergarden.EvrazCase.DTO.CarDTO;
import cybergarden.EvrazCase.DTO.CarWagonDTO;
import cybergarden.EvrazCase.entity.*;
import cybergarden.EvrazCase.exception.car.CarNotFoundByIdException;
import cybergarden.EvrazCase.exception.company.CompanyNotFoundByIdException;
import cybergarden.EvrazCase.exception.destination.DestinationNotFoundByIdException;
import cybergarden.EvrazCase.exception.head.HeadNotFoundByIdException;
import cybergarden.EvrazCase.exception.track.TrackIsNotFreeException;
import cybergarden.EvrazCase.exception.track.TrackNotFoundByIdException;
import cybergarden.EvrazCase.repo.*;
import cybergarden.EvrazCase.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarServiceimpl implements CarService {
    private final CarRepo carRepo;
    private final DestRepo destRepo;
    private final CompanyRepo companyRepo;
    private final HeadTypeRepo headTypeRepo;
    private final TrackRepo trackRepo;
    private final CarWagonRepo carWagonRepo;
    private final WagonRepo wagonRepo;

    @Autowired
    public CarServiceimpl(CarRepo carRepo,
                          DestRepo destRepo,
                          CompanyRepo companyRepo,
                          HeadTypeRepo headTypeRepo,
                          TrackRepo trackRepo,
                          CarWagonRepo carWagonRepo,
                          WagonRepo wagonRepo) {
        this.carRepo = carRepo;
        this.destRepo = destRepo;
        this.companyRepo = companyRepo;
        this.headTypeRepo = headTypeRepo;
        this.trackRepo = trackRepo;
        this.carWagonRepo = carWagonRepo;
        this.wagonRepo = wagonRepo;
    }

    @Override
    public CarEntity createCar(CarDTO carDTO, Long carId)
            throws  DestinationNotFoundByIdException,
                    CompanyNotFoundByIdException,
                    HeadNotFoundByIdException,
                    TrackNotFoundByIdException,
                    TrackIsNotFreeException {
        DestinationEntity dest = destRepo.findById(carDTO.destId()).orElse(null);
        if(dest == null) {
            throw new DestinationNotFoundByIdException("Точки назначения с таким ID не найдено.");
        }

        CompanyEntity company = companyRepo.findById(carDTO.companyId()).orElse(null);
        if(company == null) {
            throw new CompanyNotFoundByIdException("Компании с таким ID не найдено.");
        }

        HeadTypeEntity head = headTypeRepo.findById(carDTO.headId()).orElse(null);
        if(head == null) {
            throw new HeadNotFoundByIdException("Типа состава с таким ID не найдено.");
        }

        TrackEntity track = trackRepo.findById(carDTO.trackId()).orElse(null);
        if(track == null) {
            throw new TrackNotFoundByIdException("Пути с таким ID не существует.");
        }
        if(!track.getFree()) {
            throw new TrackIsNotFreeException("Этот путь уже занят.");
        }
        track.setFree(false);
        trackRepo.save(track);

        CarEntity car = new CarEntity();
        car.setDest(dest);
        car.setCompany(company);
        car.setHeadType(head);
        car.setTrack(track);
        car.setId(carId);

        return carRepo.save(car);
    }

    @Override
    public List<CarEntity> getAllCars(){
        return carRepo.findAll();
    }

    @Override
    public void deleteCar(Long carId) throws CarNotFoundByIdException {
        CarEntity car = carRepo.findById(carId).orElse(null);
        if(car == null) {
            throw new CarNotFoundByIdException("Состава с таким ID не найдено.");
        }

        companyRepo.deleteById(carId);
    }

    @Override
    public CarEntity updateCar(CarEntity updCar, Long carId) throws CarNotFoundByIdException {
        CarEntity car = carRepo.findById(carId).orElse(null);
        if(car == null) {
            throw new CarNotFoundByIdException("Состава с таким ID не найдено.");
        }

        car = parseCar(car, updCar);

        return carRepo.save(car);
    }

    @Override
    public CarEntity getCar(Long carId) throws CarNotFoundByIdException {
        CarEntity car = carRepo.findById(carId).orElse(null);
        if(car == null) {
            throw new CarNotFoundByIdException("Состава с таким ID не найдено.");
        }
        return carRepo.findById(carId).get();
    }

    private CarEntity parseCar(CarEntity car, CarEntity updCar) {
        car.setCompany(updCar.getCompany() == null ? car.getCompany() : updCar.getCompany());
        car.setDest(updCar.getDest() == null ? car.getDest() : updCar.getDest());
        car.setTrack(updCar.getTrack() == null ? car.getTrack() : updCar.getTrack());
        car.setHeadType(updCar.getHeadType() == null ? car.getHeadType() : updCar.getHeadType());
        return car;
    }
}
