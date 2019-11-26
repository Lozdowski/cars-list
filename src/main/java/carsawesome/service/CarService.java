package carsawesome.service;

import carsawesome.exception.ResourceNotFoundException;
import carsawesome.model.Car;
import carsawesome.repository.CarsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarsRepository carsRepository;

    public CarService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public Car createCar(Car car) {
        return carsRepository.save(car);
    }

    public List<Car> getCars() {
        return carsRepository.findAll();
    }
    public Car getCarById(long id) {
        return carsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("car by id: " + id + " not found"));
    }
    public Car updateCar(long id, Car car) {
        return carsRepository.findById(id).map(c->{
            c.setBio(car.getBio());
            c.setBrand(car.getBrand());
            c.setProdYear(car.getProdYear());
            c.setModel(car.getModel());
            return carsRepository.save(c);
        }).orElseThrow(()->new ResourceNotFoundException("car with id: "+ id+ " not found"));
    }
    public Car getCar(long id){
        return carsRepository.getCarById(id);
    }

    public ResponseEntity<?> deleteCarById(long id) {
        return carsRepository.findById(id).map(c->{
            carsRepository.deleteById(id);
            return new ResponseEntity<>("car by id "+id+" was deleted",HttpStatus.OK);
        }).orElseThrow(()-> new ResourceNotFoundException("car by id: "+id+" not found"));
    }


}

