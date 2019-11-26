package carsawesome.controller;

import carsawesome.model.Car;
import carsawesome.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

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
    @PutMapping("/api/cars/{id}")
    public Car updateCar(@PathVariable long id, @RequestBody Car car){
        return carService.updateCar(id,car);
    }
    @PostMapping("/api/cars/add")
    public Car createCar(@RequestBody Car car){
        return carService.createCar(car);
    }
    @DeleteMapping("/api/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable long id){
        return carService.deleteCarById(id);
    }

}
