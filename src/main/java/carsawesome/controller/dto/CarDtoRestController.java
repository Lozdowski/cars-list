package carsawesome.controller.dto;

import carsawesome.model.dto.CarDto;
import carsawesome.service.dto.CarDtoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
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

    @PostMapping("/api/cars/dto")
    public ResponseEntity<CarDto> createCar(CarDto carDto){
        CarDto result  = carDtoService.create(carDto);
        if(result == null) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // todo full crud



}
