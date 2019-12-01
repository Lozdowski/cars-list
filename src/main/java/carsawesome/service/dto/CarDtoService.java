package carsawesome.service.dto;

import carsawesome.mapper.CarMapper;
import carsawesome.mapper.CarTypeDtoMapper;
import carsawesome.model.Car;
import carsawesome.model.CarType;

import carsawesome.model.dto.CarDto;

import carsawesome.repository.CarTypeRepository;
import carsawesome.repository.CarsRepository;
import carsawesome.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDtoService {
    private static final Logger logger = LoggerFactory.getLogger(CarDtoService.class);
    private CarsRepository carsRepository;
    private CarMapper carMapper;
    private CarTypeRepository carTypeRepository;
    private TagRepository tagRepository;
    private CarTypeDtoMapper carTypeDtoMapper;


    public CarDtoService(CarsRepository carsRepository, CarMapper carMapper, CarTypeRepository carTypeRepository, TagRepository tagRepository, CarTypeDtoMapper carTypeDtoMapper) {
        this.carsRepository = carsRepository;
        this.carMapper = carMapper;
        this.carTypeRepository = carTypeRepository;
        this.tagRepository = tagRepository;
        this.carTypeDtoMapper = carTypeDtoMapper;
    }

    public List<CarDto> getCars(){
        List<CarDto> carDtos = new ArrayList<>();
        carsRepository.findAll().forEach(car->{
            carDtos.add(carMapper.map(car));
        });
        return carDtos;
    }
    public CarDto create(CarDto carDto) {
        logger.info("Received cardDto {}", carDto);
        Car car = new Car();
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setBio(carDto.getBio());
        car.setProdYear(carDto.getProdYear());

        //todo sposob 1
        //   Optional<CarType> carOptional = carTypeRepository.findCarTypeByTitleOptional(carDto.getCarType());
        //   carOptional.ifPresent(car::setCarType);

        //todo sposob 2
        CarType carType = carTypeRepository.findCarTypeByTitle(carDto.getCarType());
        if(carType == null) {
            logger.error("Error while getting carType!");
            return null;
        }

        car.setCarType(carType);
        logger.info("Try to save Car to DB {}", car);
        Car result = carsRepository.save(car);
        if(result == null) {
            logger.error("Error while save car to data base!");
            return null;
        }
        return carMapper.map(car);
    }


}
