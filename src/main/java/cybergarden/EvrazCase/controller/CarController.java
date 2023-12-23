package cybergarden.EvrazCase.controller;

import cybergarden.EvrazCase.DTO.CarDTO;
import cybergarden.EvrazCase.DTO.CarWagonDTO;
import cybergarden.EvrazCase.entity.CarEntity;
import cybergarden.EvrazCase.entity.CarWagonEntity;
import cybergarden.EvrazCase.entity.WagonEntity;
import cybergarden.EvrazCase.exception.car.CarNotFoundByIdException;
import cybergarden.EvrazCase.exception.company.CompanyNotFoundByIdException;
import cybergarden.EvrazCase.exception.destination.DestinationNotFoundByIdException;
import cybergarden.EvrazCase.exception.head.HeadNotFoundByIdException;
import cybergarden.EvrazCase.exception.track.TrackIsNotFreeException;
import cybergarden.EvrazCase.exception.track.TrackNotFoundByIdException;
import cybergarden.EvrazCase.service.CarService;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/new")
    public ResponseEntity createCar(@RequestBody CarDTO carDTO, @RequestParam Long carId) {
        try{
            return ResponseEntity.ok().body(carService.createCar(carDTO, carId));
        } catch (DestinationNotFoundByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (CompanyNotFoundByIdException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (HeadNotFoundByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (TrackNotFoundByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (TrackIsNotFreeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteCarById(@RequestParam Long carId){
        try {
            carService.deleteCar(carId);
            return ResponseEntity.ok().body("Состав успешно удален.");
        } catch (CarNotFoundByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity updateCompanyById(@RequestBody CarEntity car, @RequestParam Long carId) {
        try {
            return ResponseEntity.ok().body(carService.updateCar(car, carId));
        } catch (CarNotFoundByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity getCarById(@RequestParam Long carId) {
        try{
            return ResponseEntity.ok().body(carService.getCar(carId));
        } catch (CarNotFoundByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/all")
    public ResponseEntity getAllCars() {
        try {
            List<CarEntity> cars = carService.getAllCars();
            return ResponseEntity.ok().body(cars);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
