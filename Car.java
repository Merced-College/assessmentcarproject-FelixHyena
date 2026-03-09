/* 
 * Jessie Mendez Cruz
 * 3-9-2026
 * Car Data Analyzer
 */

//class that sets up variables, the constructor,
//the getters, and the toString()

public class Car {
    //variables
    private int carId;
    private String brand;
    private String model;
    private int year;
    private String fuelType;
    private double mileage;

//constructor
public Car(int carID, String brand, String model, 
    int year, String fuelType, String color, double mileage){

    this.carID = carID;
    this.brand = brand;
    this.model = model;
    this.year = year;
    this.fuelType = fuelType;
    this.color = color;
    this.mileage = mileage;
    }

    //getters
    public int getID(){
        return carID;
    }

        public int getBrand(){
        return brand;
    }

        public int getModel(){
        return model;
    }

        public int getYear(){
        return year;
    }

        public int getFuel(){
        return fuelType;
    }

        public int getColor(){
        return color;
    }

        public int getMileage(){
        return mileage;
    }

    //print Car details
    public String toString(){
        return carID + " " + brand + " " + model + " " + year +
           " " + fuelType + " " + color + " " + mileage;
    }

}

