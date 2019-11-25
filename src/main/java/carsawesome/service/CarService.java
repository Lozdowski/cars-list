package carsawesome.service;

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

    public String addCar(Car car) {
        Car result = carsRepository.save(car);
        if (result == null) {
            return "error while adding new car to list";
        }
        return "add " + result.getBrand() + " to collection";
    }

    public List<Car> getCars() {
        return carsRepository.findAll();
    }

    public void deleteCar(Long id) {
        carsRepository.deleteById(id);
    }


    public String updateCar(Car car) {
        Car result = carsRepository.save(car);
        if (result == null) {
            return "error while adding updating car to list";
        }
        return "updated " + result.getBrand() + " in collection";
    }
    public Car getCarById(long id){
        return carsRepository.getCarById(id);
    }



    // layer of api methods
    public Car ApiAddiCar(Car car) {
        return  carsRepository.save(car);

    }



}

