package lambda;

import java.util.ArrayList;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(9);
        numbers.add(131);
        numbers.add(14);
        numbers.add(9);
        numbers.add(10);
        numbers.add(4);
        numbers.add(12);
        numbers.add(15);

        //Example 1: Create a method that prints the elements in a List on the same line with spaces between them.
        numbers.
                stream().
                forEach(t -> System.out.print(t + " "));//12 9 131 14 9 10 4 12 15

        System.out.println();

        //Example 2: Create a method that prints the even elements in a List on the same line with a space between them.
        numbers.
                stream().
                filter(t -> t%2 == 0).
                forEach(t -> System.out.print(t + " "));//12 14 10 4 12

        System.out.println();

        //Example 3: Create a method that prints the squares of odd elements in a List on the same line with a space between them.
        numbers.
                stream().
                filter(t -> t%2 != 0).
                map(t -> t * t).
                forEach(t -> System.out.print(t + " "));//81 17161 81 225

        System.out.println();

        //Example 4: Create a method that prints the cubes of odd elements in a List, without repetition, on the same line,
        // with spaces between them.
        numbers.
                stream().
                distinct().
                filter(t -> t%2 != 0).
                map(t -> t * t * t).
                forEach(t -> System.out.print(t + " "));//729 2248091 3375

        System.out.println();

        //Example 5: Create a method to calculate the sum of the squares of distinct even elements.
        int sum = numbers.
                stream().
                distinct().
                filter(t -> t%2 == 0).
                map(t -> t * t).
                reduce((t, u) -> t + u).
                get();
        System.out.println(sum);//456

        //Example 6: Create a method to calculate the product of the square of distinct even elements.
        int product = numbers.
                stream().
                distinct().
                filter(t -> t%2 == 0).
                map(t -> t * t).
                reduce((t, u) -> t * u).
                get();
        System.out.println(product);//45158400

        //Example 7: Create a method to find the maximum value from the List elements.
        int max = numbers.
                stream().
                sorted().
                reduce((t, u) -> u).
                get();
            //int max = numbers.stream().sorted(Comparator.reverseOrder()).reduce((t, u) -> t).get();
        System.out.println(max);//131

        //Example 8: Create a method to find the minimum value from the list elements.
        int min = numbers.
                stream().
                sorted().
                reduce((t, u) -> t).
                get();
        System.out.println(min);//4

        //Example 9: Create a method to find the minimum value which is greater than 7 and even from the list elements.
        int minGreaterThanSeven = numbers.
                stream().
                filter(t -> t > 7 && t%2 == 0).
                sorted().
                reduce((t, u) -> t).
                get();
        System.out.println(minGreaterThanSeven);//10

        //Example 10: Create a method to find the maximum value which is smaller than 12, distinct and odd from the list elements.
        int maxSmallerThanTwelve = numbers.
                stream().
                distinct().
                filter(t -> t < 12 && t%2 != 0).
                sorted().
                reduce((t, u) -> u).
                get();
        System.out.println(maxSmallerThanTwelve);//9
    }
}