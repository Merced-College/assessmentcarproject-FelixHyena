//Jessie Mendez Cruz
//3-9-2026
//Car Data Assessment

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Car> working = new ArrayList<>();

    public static void main(String[] args) {

        // load cars from CSV file
        cars = loadCars("Car_Data.csv");

        // working list of first 2000 cars
        working = new ArrayList<>(cars.subList(0, Math.min(2000, cars.size())));

        // print first 10 cars
        System.out.println("First 10 cars loaded:");
        for (int i = 0; i < Math.min(10, cars.size()); i++) {
            System.out.println(cars.get(i));
        }

        Scanner scnr = new Scanner(System.in);

        while (true) {
            System.out.println("\nSearch Options:");
            System.out.println("1. Search by Year Range");
            System.out.println("2. Search by Color");
            System.out.println("3. Show Stats");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scnr.nextInt();

            if (choice == 1) {

                System.out.print("Enter start year: ");
                int start = scnr.nextInt();

                System.out.print("Enter end year: ");
                int end = scnr.nextInt();

                sortByYear();
                searchByYearRange(start, end);

            } else if (choice == 2) {

                scnr.nextLine(); // clears leftover enter

                System.out.print("Enter color: ");
                String color = scnr.nextLine();

                sortByColor();
                searchByColor(color);

            } else if (choice == 3) {

                showStats();

            } else if (choice == 4) {

                System.out.println("Program ended.");
                break;

            } else {

                System.out.println("Invalid option.");
            }
        }
    }

    // sort cars by year using selection sort
    public static void sortByYear() {
        for (int i = 0; i < working.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < working.size(); j++) {
                if (working.get(j).getYear() < working.get(minIndex).getYear()) {
                    minIndex = j;
                }
            }

            Car temp = working.get(i);
            working.set(i, working.get(minIndex));
            working.set(minIndex, temp);
        }

        System.out.println("\nFirst 10 cars after sorting by year:");
        for (int i = 0; i < Math.min(10, working.size()); i++) {
            System.out.println(working.get(i));
        }
    }

    // sort cars by color using selection sort
    public static void sortByColor() {
        for (int i = 0; i < working.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < working.size(); j++) {
                String c1 = working.get(j).getColor().toLowerCase();
                String c2 = working.get(minIndex).getColor().toLowerCase();

                if (c1.compareTo(c2) < 0) {
                    minIndex = j;
                }
            }

            Car temp = working.get(i);
            working.set(i, working.get(minIndex));
            working.set(minIndex, temp);
        }

        System.out.println("\nFirst 10 cars after sorting by color:");
        for (int i = 0; i < Math.min(10, working.size()); i++) {
            System.out.println(working.get(i));
        }
    }

    // search by year range, only show up to 10 cars
    public static void searchByYearRange(int startYear, int endYear) {
        System.out.println("\nCars between " + startYear + " and " + endYear + ":");

        int count = 0;

        for (Car c : working) {
            if (c.getYear() >= startYear && c.getYear() <= endYear) {
                System.out.println(c);
                count++;

                if (count == 10) {
                    break;
                }
            }
        }

        if (count == 0) {
            System.out.println("No cars found in that year range.");
        }
    }

    // search by color, only show up to 10 cars
    public static void searchByColor(String color) {
        System.out.println("\nCars with color " + color + ":");

        int count = 0;

        for (Car c : working) {
            if (c.getColor().equalsIgnoreCase(color)) {
                System.out.println(c);
                count++;

                if (count == 10) {
                    break;
                }
            }
        }

        if (count == 0) {
            System.out.println("No cars found with that color.");
        }
    }

    // stats: average mileage and count by fuel type
    public static void showStats() {
        double totalMileage = 0;

        int petrol = 0;
        int diesel = 0;
        int electric = 0;
        int hybrid = 0;
        int cng = 0;

        for (Car c : working) {
            totalMileage += c.getMileage();

            if (c.getFuelType().equalsIgnoreCase("Petrol")) {
                petrol++;
            } else if (c.getFuelType().equalsIgnoreCase("Diesel")) {
                diesel++;
            } else if (c.getFuelType().equalsIgnoreCase("Electric")) {
                electric++;
            } else if (c.getFuelType().equalsIgnoreCase("Hybrid")) {
                hybrid++;
            } else if (c.getFuelType().equalsIgnoreCase("CNG")) {
                cng++;
            }
        }

        double averageMileage = totalMileage / working.size();

        System.out.println("\nStats for working list:");
        System.out.println("Average mileage: " + averageMileage);
        System.out.println("Petrol: " + petrol);
        System.out.println("Diesel: " + diesel);
        System.out.println("Electric: " + electric);
        System.out.println("Hybrid: " + hybrid);
        System.out.println("CNG: " + cng);
    }

    // load cars from CSV
    public static ArrayList<Car> loadCars(String fileName) {
        ArrayList<Car> list = new ArrayList<>();

        try {
            Scanner file = new Scanner(new File(fileName));
            file.nextLine(); // skip header

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

            file.close();

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }

        System.out.println("Total cars loaded: " + list.size());
        return list;
    }
}