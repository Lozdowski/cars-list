package carsawesome.controller;

import carsawesome.model.Car;
import carsawesome.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getHomePage(Model model, @RequestParam(value = "message" ,required = false) String resultMessage){
        String welcome = "Add car to a list of cars: ";
        model.addAttribute("welcome", welcome);
        model.addAttribute("resultMessage",resultMessage);
        model.addAttribute("cars",carService.getCars());
        return "index";
    }
    @PostMapping("/cars/add")
    public String addCar(@ModelAttribute Car inCar, Model model){
        Car car = new Car();
        car.setBrand(inCar.getBrand());
        car.setModel(inCar.getModel());
        car.setProdYear(inCar.getProdYear());
        car.setBio(inCar.getBio());
        model.addAttribute("car",car);
        carService.createCar(car);
        return "redirect:/cars";
    }
    @GetMapping("/cars/delete")
    public String deleteCar(@RequestParam long id){
        carService.deleteCarById(id);
        return "redirect:/cars";

    }
    @GetMapping("/cars/update")
    public String updateCar(@RequestParam  long id, Model model){
        Car car = carService.getCar(id);
        if(car==null) return "cannot find car to update !";
        model.addAttribute("car",car);
        System.out.println(car);
        return "update";
        //    return carService.updateCar(car);
    }
    @PostMapping("cars/update/confirm")
    public String updateCarConfirm(@ModelAttribute Car inCar) {
        Car car = new Car();
        car.setId(inCar.getId());
        car.setBrand(inCar.getBrand());
        car.setModel(inCar.getModel());
        car.setProdYear(inCar.getProdYear());
        car.setBio(inCar.getBio());
        carService.createCar(car);
        return "redirect:/cars?message=" + car;
    }


}
