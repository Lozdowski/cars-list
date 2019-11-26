package carsawesome.controller;

import carsawesome.model.CarType;
import carsawesome.service.CarTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CarTypeController {

    private CarTypeService carTypeService;

    public CarTypeController(CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
    }

    @GetMapping("api/cars/types")
    public List<CarType> getCarTypers(){
        return carTypeService.getCarTypes();
    }
    @PostMapping("/api/cars/type")
    public CarType createCarType(@RequestBody CarType carType){
        return carTypeService.createCarType(carType);
    }

}
