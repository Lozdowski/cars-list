package carsawesome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String prodYear;
    private String bio;
    @ManyToOne(fetch= FetchType.LAZY, optional = false)
    @JoinColumn(name ="car_type_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private CarType carType;
    @ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cars_tags",
            joinColumns = {@JoinColumn(name = "car_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();

    public Car(@NotNull String brand, @NotNull String model, @NotNull String prodYear, String bio, CarType carType, Set<Tag> tags) {
        this.brand = brand;
        this.model = model;
        this.prodYear = prodYear;
        this.bio = bio;
        this.carType = carType;
        this.tags = tags;
    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProdYear() {
        return prodYear;
    }

    public void setProdYear(String prodYear) {
        this.prodYear = prodYear;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", prodYear='" + prodYear + '\'' +
                ", bio='" + bio + '\'' +
                ", carType=" + carType +
                '}';
    }
}