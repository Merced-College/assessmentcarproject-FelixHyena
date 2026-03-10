//Jessie Mendez Cruz
//3-9-2026
//Car Data Assessment

//Class
public class Car {
	//Variables
	private String carID;
	private String brand;
	private String model;
	private int year;
	private String fuelType;
	private String color;
	private double mileage;
	
	//object
	public Car(String carID, String brand, String model, int year, String fuelType, String color, double mileage) {
		
		this.carID = carID;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.fuelType = fuelType;
		this.color = color;
		this.mileage = mileage;
		
	}
	
	//getters
	public String getCarID(){
		return carID;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getFuelType() {
		return fuelType;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getMileage() {
		return mileage;
	}
	
	//Prints car details from csv using toString()
	
	public String toString() {
		return carID + " " + brand + " " + model + " " + year + " " + fuelType + " " + color + " " + mileage;
	}
}