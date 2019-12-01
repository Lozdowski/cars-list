package carsawesome.service;

import carsawesome.exception.ResourceNotFoundException;
import carsawesome.model.CarType;
import carsawesome.repository.CarTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypeService {

    private CarTypeRepository carTypeRepository;

    public CarTypeService(CarTypeRepository carTypeRepository){
        this.carTypeRepository = carTypeRepository;
    }

    public List<CarType> getCarTypes(){
       return carTypeRepository.findAll();
    }
    public CarType getCarType(long id){
        return carTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("car type id: "+id+ " not found!"));
    }

    public CarType createCarType(CarType carType){
        return carTypeRepository.save(carType);
    }
    public CarType UpdateCarType(long id,CarType carType){
       return carTypeRepository.findById(id).map(ct -> {
            ct.setTitle(carType.getTitle());
            return carTypeRepository.save(ct);
        }).orElseThrow(() -> new ResourceNotFoundException("car type id: " + id + " not found!"));
    }
    public ResponseEntity<?> deleteCarType(long id){
        return carTypeRepository.findById(id).map(ct -> {
            carTypeRepository.deleteById(id);
            return new ResponseEntity<>("car type by id "+id+" was deletad", HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("car type id: " + id + " not found!"));
    }


}
