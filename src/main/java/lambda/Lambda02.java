package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda02 {

    public static void main(String[] args) {

        List<String> artists = new ArrayList<>();
        artists.add("Tom");
        artists.add("John");
        artists.add("Walt");
        artists.add("Angelina");
        artists.add("Tom");
        artists.add("Brad");
        artists.add("Morgan");

        //Example 1: Print all list elements in uppercase alphabetical order, on the same line, without repetition.
        //artists.stream().distinct().map(String::toUpperCase).sorted().forEach(System.out::print);
        artists.
                stream().
                distinct().
                map(String::toUpperCase).
                sorted().
                forEach(Utils::printElementsOnTheSameLineWithSpace);//ANGELINA BRAD JOHN MORGAN TOM WALT

        System.out.println();

        //Example 2: Print all list elements in lowercase letters, in reverse alphabetical order, on the same line, without repetition.
        artists.
                stream().
                distinct().
                map(String::toLowerCase).
                sorted(Comparator.reverseOrder()).
                forEach(Utils::printElementsOnTheSameLineWithSpace);//walt tom morgan john brad angelina

        System.out.println();

        //Example 3: Print all list elements in uppercase letters, in ascending order of length, on the same line, without repetition.
        artists.
                stream().
                distinct().
                map(String::toUpperCase).
                sorted(Comparator.comparing(String::length)).
                forEach(Utils::printElementsOnTheSameLineWithSpace);//TOM JOHN WALT BRAD MORGAN ANGELİNA

        System.out.println();

        //Example 4: Print all list elements in uppercase letters, in ascending order according to their last letters,
        //on the same line, without repetition.
        artists.
                stream().
                distinct().
                map(String::toUpperCase).
                sorted(Comparator.comparing(Utils::getLastCharacter)).
                forEach(Utils::printElementsOnTheSameLineWithSpace);//ANGELİNA BRAD TOM JOHN MORGAN WALT

        System.out.println();

        //Example 5: Print all list elements in uppercase letters, in descending order according to their last letters,
        //on the same line, without repetition.
        artists.
                stream().
                distinct().
                map(String::toUpperCase).
                sorted(Comparator.comparing(Utils::getLastCharacter).reversed()).
                forEach(Utils::printElementsOnTheSameLineWithSpace);//WALT JOHN MORGAN TOM BRAD ANGELİNA

        System.out.println();

        //Example 6: Print all list elements in uppercase letters, their lengths in ascending order, on the same line
        //without repetition, and elements with the same length are in alphabetical order.
        artists.
                stream().
                distinct().
                map(String::toUpperCase).
                sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).
                forEach(Utils::printElementsOnTheSameLineWithSpace);//TOM BRAD JOHN WALT MORGAN ANGELİNA

        System.out.println();

        //Example 7: Delete the elements with more than 5 characters and print the result on the same line with a space.
        artists.
                removeIf(t -> t.length() > 5);
        artists.
                stream().
                distinct().
                forEach(Utils::printElementsOnTheSameLineWithSpace);//Tom John Walt Brad

        System.out.println();

        artists.add("Angelina");
        artists.add("Morgan");

        //Example 8: Delete the elements starting with "A" or ending with "d" from the list.
        artists.
                removeIf(t -> t.startsWith("A") || t.endsWith("d"));
        artists.
                stream().
                distinct().
                forEach(Utils::printElementsOnTheSameLineWithSpace);//Tom John Walt Morgan

        System.out.println();

        artists.add("Angelina");
        artists.add("Brad");

        //Example 9: Get the squares of the character numbers of the List elements and print them to the console on the
        //same line with a space.
        System.out.println(artists);//[Tom, John, Walt, Tom, Morgan, Angelina, Brad]
        artists.
                stream().
                map(t -> t.length() * t.length()).
                forEach(Utils::printElementsOnTheSameLineWithSpace);//9 16 16 9 36 64 16

        System.out.println();

        //Example 10: Print List elements with an even number of characters to the console on the same line with a space.
        artists.
                stream().
                filter(t -> t.length()%2 == 0).
                forEach(Utils::printElementsOnTheSameLineWithSpace);//John Walt Morgan Angelina Brad
    }
}