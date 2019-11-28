package carsawesome.controller.dto;

import carsawesome.model.dto.CarDto;
import carsawesome.service.dto.CarDtoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CarDtoRestController {
    private CarDtoService carDtoService;
    public  CarDtoRestController(CarDtoService carDtoService){
        this.carDtoService = carDtoService;
    }

    @GetMapping("/api/cars/dto")
    public List<CarDto> getCars(){
        return carDtoService.getCars();
    }



}
