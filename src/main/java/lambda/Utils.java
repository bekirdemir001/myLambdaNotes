package lambda;

public class Utils {

    public static void printElementsOnTheSameLineWithSpace(Object obj){
        System.out.print(obj + " ");
    }

    public static String getLastCharacter(String str){
        return str.substring(str.length()-1);
    }

    public static int getSumOfDigits (int a){
        int sum = 0;
        while (a > 0){
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

}