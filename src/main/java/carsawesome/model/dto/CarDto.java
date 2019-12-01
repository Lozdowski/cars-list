package carsawesome.model.dto;

public class CarDto {
    private String brand;
    private String model;
    private String prodYear;
    private String bio;
    private String carType;

    public CarDto() {
    }

    private CarDto(Builder b){
        this();
        this.brand = b.brand;
        this.model = b.model;
        this.carType = b.carType;
        this.bio = b.bio;
        this.prodYear = b.prodYear;

    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProdYear(String prodYear) {
        this.prodYear = prodYear;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getProdYear() {
        return prodYear;
    }

    public String getBio() {
        return bio;
    }

    public String getCarType() {
        return carType;
    }

    public static class Builder{
        private String brand;
        private String model;
        private String prodYear;
        private String bio;
        private String carType;

        public Builder(){

        }


        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder prodYear(String prodYear) {
            this.prodYear = prodYear;
            return this;
        }

        public Builder bio(String bio) {
            this.bio = bio;
            return this;
        }

        public Builder carType(String carType) {
            this.carType = carType;
            return this;
        }
        public CarDto build(){
            return new CarDto(this);
        }
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", prodYear='" + prodYear + '\'' +
                ", bio='" + bio + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
