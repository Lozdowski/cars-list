package carsawesome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CarType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carType", cascade = CascadeType.ALL)
    private Set<Car> cars = new HashSet<>();

    public CarType(String title, Set<Car> cars) {
        this.title = title;
        this.cars = cars;
    }


    public CarType(String title) {
        this();
        this.title = title;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public CarType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
