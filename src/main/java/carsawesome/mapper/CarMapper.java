package carsawesome.mapper;

import carsawesome.model.Car;
import carsawesome.model.dto.CarDto;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements Mapper<Car, CarDto> {


    @Override
    public CarDto map(Car from) {
        return new CarDto
                .Builder()
                .brand(from.getBrand())
                .carType(from.getCarType().getType())
                .bio(from.getBio())
                .model(from.getModel())
                .prodYear(from.getProdYear())
                .build();
    }
}
