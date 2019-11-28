package carsawesome.service.dto;

import carsawesome.mapper.CarMapper;
import carsawesome.model.dto.CarDto;
import carsawesome.repository.CarsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDtoService {
    private CarsRepository carsRepository;
    private CarMapper carMapper;

    public CarDtoService(CarsRepository carsRepository, CarMapper carMapper){
        this.carsRepository = carsRepository;
        this.carMapper = carMapper;
    }

    public List<CarDto> getCars(){
        List<CarDto> carDtos = new ArrayList<>();
        carsRepository.findAll().forEach(car->{
            carDtos.add(carMapper.map(car));
        });
        return carDtos;
    }


}
