package com.example.CarRental;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestController
public class CarRentalService {

	private List<Car> cars = new ArrayList<Car>();
	
	public CarRentalService() {
		cars.add(new Car("11AA11", "Ferrari", 2 , 1000));
		cars.add(new Car("22BB22", "Porshe", 2, 2222));
		cars.add(new Car("33CC33", "Wolkswagen", 5, 500));
		cars.add(new Car("44DD44", "Proton", 4, 250));
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Car> listOfCars(){
		return cars;
		
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Car getACar(@PathVariable("plateNumber") String plateNumber) throws Exception{
		
		for(Car car:cars)
		{
			if(car.getPlateNumber().equals(plateNumber))
			{
				return car;
			}
		}
		return null;
		
	} 
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/cars/{plateNumber}?rent=true", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void rent(@PathVariable("plateNumber") String plateNumber) throws Exception{
		
		for(Car car:cars)
		{
			if(car.getPlateNumber().equals(plateNumber))
			{	
				car.setBegin("16/11/2019");
			}
		}

	} 
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/cars/{plateNumber}?rent=false", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void GetBackTheCar(@PathVariable("plateNumber") String plateNumber) throws Exception{
		
		for(Car car:cars)
		{
			if(car.getPlateNumber().equals(plateNumber))
			{	
				car.setEnd("29/11/2019");
			}
		}
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Car addCar(@RequestBody Car car)throws Exception{
		cars.add(car);
		return car;
	}

	

	
}
