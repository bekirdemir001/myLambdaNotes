package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lambda03 {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        myList.add(12);
        myList.add(8);
        myList.add(23);
        myList.add(10);
        myList.add(7);

        //Example 1: Type the code to find the sum of all numbers in the given List.
        //1.Way: For-Each-Loop
        int sum = 0;
        for (int w : myList){
            sum += w;
        }
        System.out.println("Sum of numbers(For-Each-Loop): " + sum);//60

        //2.Way: Lambda
        int sum2 = myList.stream().reduce(Math::addExact).get();
        System.out.println("Sum of numbers(Lambda): " + sum2);//60

        //Example 2: Type the code that returns the sum of all integers from 7 to 70.
        int sum4 = IntStream.rangeClosed(7,70).reduce(Math::addExact).getAsInt();
        System.out.println(sum4);//2464

        //Example 3: Type the code that multiplies all integers from 3 to 9.
        //1. Way: rangeClosed()
        int multiply1 = IntStream.rangeClosed(3, 9).reduce(Math::multiplyExact).getAsInt();
        System.out.println(multiply1);//181440

        //2. Way: range()
        int multiply2 = IntStream.range(3, 10).reduce(Math::multiplyExact).getAsInt();
        System.out.println(multiply2);//181440

        //Example 4: Type the code that calculates the factorial of the given number.
        int factorial = getFactorial (5);
        System.out.println(factorial);//120

        //Example 5: Type the code that gives you the sum of all even numbers between two given integers.
        int sumEvens1 = getSumOfEvensBetweenTwoNumbers(3,6);
        int sumEvens2 = getSumOfEvensBetweenTwoNumbers(6,3);
        System.out.println(sumEvens1);//10
        System.out.println(sumEvens2);//10

        //Example 6: Create a method that gives you the sum of the digits of all integers between two given integers.
        //     12 and 18 --> 13 14 15 16 17 --> 4+5+6+7+8 = 30
        int sumDigits1 = getSumOfDigitsBetweenTwoNumbers(12, 18);
        int sumDigits2 = getSumOfDigitsBetweenTwoNumbers(18, 12);
        System.out.println(sumDigits1);//30
        System.out.println(sumDigits2);//30


    }

    //Example 4: Type the code that calculates the factorial of the given number.
    public static int getFactorial (int a){

        if (a < 0){
            System.out.println("Factorial Operations cannot be applied to negative numbers!");
            return -1;
        } else if (a == 0) {
            return 1;
        }else {
            return IntStream.rangeClosed(1, a).reduce(Math::multiplyExact).getAsInt();
        }
    }

    //Example 5: Type the code that gives you the sum of all even numbers between two given integers.
    public static int getSumOfEvensBetweenTwoNumbers (int a, int b){

        if (a>b){
            //Swap Operation
            a = a + b;
            b = a - b;
            a = a - b;
        }
        return IntStream.rangeClosed(a, b).filter(t -> t%2 == 0).sum();
    }

    //Example 6: Create a method that gives you the sum of the digits of all integers between two given integers.
    //     12 and 18 --> 13 14 15 16 17 --> 4+5+6+7+8 = 30
    public static int getSumOfDigitsBetweenTwoNumbers (int a, int b){

        if (a > b){
            a = a + b;
            b = a - b;
            a = a - b;
        }
        return IntStream.rangeClosed(a+1, b-1).map(Utils::getSumOfDigits).sum();
    }

}