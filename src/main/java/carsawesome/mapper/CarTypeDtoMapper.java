package carsawesome.mapper;

import carsawesome.model.Car;
import carsawesome.model.CarType;
import carsawesome.model.dto.CarTypeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Component
public class CarTypeDtoMapper implements Mapper<CarType, CarTypeDto> {
    @Override
    public CarTypeDto map(CarType from) {
        List<String> cars = from.getCars()
                .stream()
                .map(CarsToString.INSTANCE).collect(Collectors.toList());

        return new CarTypeDto(from.getType(),cars);

    }

    private enum CarsToString implements Function<Car, String>{
        INSTANCE;

        @Override
        public String apply(Car car) {
            return car.getBrand();
        }
    }
}
