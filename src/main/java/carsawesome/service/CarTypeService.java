package carsawesome.service;

import carsawesome.exception.ResourceNotFoundException;
import carsawesome.model.CarType;
import carsawesome.repository.CarTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class CarTypeService {

    private CarTypeRepository carTypeRepository;

    public CarTypeService(CarTypeRepository carTypeRepository){
        this.carTypeRepository = carTypeRepository;
    }

    public List<CarType> getCarTypes(){
       return carTypeRepository.findAll();
    }

    public CarType createCarType(CarType carType){
        return carTypeRepository.save(carType);
    }
    public CarType UpdateCarType(long id,CarType carType){
       return carTypeRepository.findById(id).map(ct -> {
            ct.setType(carType.getType());
            return carTypeRepository.save(ct);
        }).orElseThrow(() -> new ResourceNotFoundException("car type id: " + id + " not found!"));
    }
    public ResponseEntity<?> deleteCarType(long id){
        return carTypeRepository.findById(id).map(ct -> {
            carTypeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("car type id: " + id + " not found!"));
    }


}
