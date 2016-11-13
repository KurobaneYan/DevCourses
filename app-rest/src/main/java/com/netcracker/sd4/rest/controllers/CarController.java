package com.netcracker.sd4.rest.controllers;

import com.netcracker.sd4.rest.dto.CarDto;
import com.netcracker.sd4.rest.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarDto> getCars() {
        return carService.getAllCars();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public CarDto createCar(@RequestBody CarDto carDto) {
        return carService.addCar(carDto);
    }

    @RequestMapping(value = "/{model}", method = RequestMethod.PUT)
    public CarDto updateCar(@PathVariable String model, @RequestBody CarDto carDto) {
        return carService.updateCar(model, carDto);
    }

    @RequestMapping(value = "/{carModel}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable String carModel) {
        carService.deleteCar(carModel);
    }
}
