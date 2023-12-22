package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda05 {

    public static void main(String[] args) {

        Car car1 = new Car("Toyota", "Corolla", 2020, 40000, "gasoline");
        Car car2 = new Car("Honda", "Civic", 2018, 65000, "gasoline");
        Car car3 = new Car("Mercedes", "C-200", 2021, 10000, "diesel");
        Car car4 = new Car("BMV", "X6", 2023, 1000, "diesel");
        Car car5 = new Car("Seat", "Leon", 2016, 105000, "diesel");
        Car car6 = new Car("Honda", "CRV", 2022, 40000, "hybrid");
        Car car7 = new Car("Tesla", "Model Y", 2023, 1500, "electric");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
        carList.add(car7);

        //Example 1: Type the code that checks whether all "years" are greater than 2015.
        boolean b1 = carList.stream().allMatch(t -> t.getYear() > 2015);
        System.out.println(b1);//true

        //Example 2: Type code that checks whether at least one of the car models contains the word "Suzuki".
        boolean b2 = carList.stream().anyMatch(t -> t.getMake().contains("Suzuki"));
        System.out.println(b2);//false

        //Example 3: Type the code that prints the model of the car with the highest mileage on the console.
        String str1 = carList.stream().max(Comparator.comparing(Car::getKm)).get().getModel();
        System.out.println(str1);//Leon

        //Example 4: Arrange all car objects from smallest to largest according to mileage and print them to the console
        //as a List except the first two.
        List<Car> list1 = carList.stream().sorted(Comparator.comparing(Car::getKm)).skip(2).toList();
        System.out.println(list1);

        //Example 5: Sort all car objects by mileage from smallest to largest and print the first three as a list to the console.
        List<Car> list2 = carList.stream().sorted(Comparator.comparing(Car::getKm)).limit(3).toList();
        System.out.println(list2);

        //Example 6: Sort all car objects by mileage from smallest to largest and print the third as a List to the console.
        List<Car> list3 = carList.stream().sorted(Comparator.comparing(Car::getKm)).skip(2).limit(1).toList();
        System.out.println(list3);


    }
}