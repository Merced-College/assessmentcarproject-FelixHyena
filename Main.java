//Jessie Mendez Cruz
//3-9-2026
//Car Data Assessment

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args) {

        // load cars from CSV file
        cars = loadCars("Car_Data.csv");

        // print first 10 cars to confirm loading worked
        System.out.println("First 10 cars loaded:");

        for (int i = 0; i < Math.min(10, cars.size()); i++) {
            System.out.println(cars.get(i));
        }
    }

    // load cars method that looks at and reads that file
    public static ArrayList<Car> loadCars(String fileName) {

        // creates new ArrayList that stores each object (car) from the file
        ArrayList<Car> list = new ArrayList<>();
        
        //verifies that the file is read
        try {  	
            Scanner file = new Scanner(new File(fileName));
            file.nextLine(); // skip header
            
            //parses and organizes the lines
            while (file.hasNextLine()) {

                String line = file.nextLine();
                String[] parts = line.split(",");

                String id = parts[0].trim();
                String brand = parts[1];
                String model = parts[2];
                int year = Integer.parseInt(parts[3]);
                String fuel = parts[4];
                String color = parts[5];
                double mileage = Double.parseDouble(parts[6]);

                Car car = new Car(id, brand, model, year, fuel, color, mileage);
                list.add(car);
            }
            // closes file
            file.close();
            
            //in case file cant be read
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
        
        //output of car list size
        System.out.println("Total cars loaded: " + list.size());

        return list;
    }
}

