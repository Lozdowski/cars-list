package carsawesome.controller;

import carsawesome.model.Car;
import carsawesome.repository.CarsRepository;
import carsawesome.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarRestController {

    private CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/cars")
    public List<Car> getCars(){
        return carService.getCars();
    }
    @GetMapping("api/cars/{id}")
    public Car getCar(@PathVariable long id){
        return carService.getCarById(id);
    }
    @PostMapping("/api/cars/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car newCar = carService.ApiAddiCar(car);
        if(newCar ==null) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(newCar, HttpStatus.OK);
    }
}
