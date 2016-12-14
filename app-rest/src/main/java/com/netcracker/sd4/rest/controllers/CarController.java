package com.netcracker.sd4.rest.controllers;

import com.netcracker.sd4.rest.dto.CarDto;
import com.netcracker.sd4.rest.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarDto> getCars() {
        return carService.getAllCars();
    }

    @RequestMapping(value = "/{page}/{pageSize}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarDto> getCarsForPage(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {
        return carService.getCarsForPage(page, pageSize);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
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

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long countCars() {
        return carService.countCars();
    }

    @RequestMapping(value = "/search/{keyword}/{page}/{pageSize}", method = RequestMethod.GET)
    public List<CarDto> searchCarWithPagination(@PathVariable("keyword") String keyword, @PathVariable("page") int page,
                                                @PathVariable("pageSize") int pageSize) {
        return carService.searchCarWithPagination(keyword, page, pageSize);
    }
}
