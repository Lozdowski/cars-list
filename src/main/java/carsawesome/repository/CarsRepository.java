package carsawesome.repository;

import carsawesome.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarsRepository extends JpaRepository<Car,Long> {

    @Query("select c from Car c where c.id=?1")
    Car getCarById(long id);
}

