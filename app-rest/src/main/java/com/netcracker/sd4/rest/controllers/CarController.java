package com.netcracker.sd4.rest.controllers;

import com.netcracker.sd4.rest.dto.CarDto;
import com.netcracker.sd4.rest.services.CarServiceInterface;
import com.netcracker.sd4.rest.services.impl.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarServiceInterface carService;

    @Autowired
    public void setCarService(CarServiceInterface carService) {
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
    public CarDto updateCountry(@PathVariable String model, @RequestBody CarDto carDto) {
        return carService.updateCar(model, carDto);
    }

    @RequestMapping(value = "/{carModel}", method = RequestMethod.DELETE)
    public void deleteCountry(@PathVariable String carModel) {
        carService.deleteCar(carModel);
    }
}
