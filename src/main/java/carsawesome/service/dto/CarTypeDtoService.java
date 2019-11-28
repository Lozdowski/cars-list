package carsawesome.service.dto;

import carsawesome.mapper.CarTypeDtoMapper;
import carsawesome.model.dto.CarTypeDto;
import carsawesome.repository.CarTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarTypeDtoService {

    private CarTypeRepository carTypeRepository;
    CarTypeDtoMapper carTypeDtoMapper;

    public CarTypeDtoService(CarTypeRepository carTypeRepository, CarTypeDtoMapper carTypeDtoMapper) {
        this.carTypeRepository = carTypeRepository;
        this.carTypeDtoMapper = carTypeDtoMapper;
    }

    public List<CarTypeDto> getCarTypes(){
        List<CarTypeDto> carTypeDtos = new ArrayList<>();
         carTypeRepository.findAll()
                 .forEach(t -> carTypeDtos.add(carTypeDtoMapper.map(t)));
         return carTypeDtos;
    }
}
