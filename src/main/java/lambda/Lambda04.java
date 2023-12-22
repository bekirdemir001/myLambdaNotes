package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Lambda04 {

    public static void main(String[] args) throws IOException {

        //Example 1: Type the code that prints the text in the LambdaTextFile file to the console.
        Files.lines(Path.of("src/main/java/lambda/LambdaTextFile.txt")).forEach(System.out::println);

        //Example 2: Type the code that makes each character uppercase in the LambdaTextFile file.
        Files.lines(Path.of("src/main/java/lambda/LambdaTextFile.txt")).map(String::toUpperCase).forEach(System.out::println);

        //Example 3: Create a method that shows whether any word in the LambdaTextFile file exists.
        boolean b1 = isExistAnyWord("src/main/java/lambda/LambdaTextFile.txt", "Java");
        System.out.println(b1);//true

        //Example 4: Type the code that shows whether each word in the LambdaTextFile file contains "a" or not.
        boolean b2 = Files.
                lines(Path.of("src/main/java/lambda/LambdaTextFile.txt")).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                allMatch(t -> t.contains("a"));
        System.out.println(b2);//false

        //Example 5: Type the code to show that no word in the LambdaTextFile file contains "x".
        boolean b3 = Files.
                lines(Path.of("src/main/java/lambda/LambdaTextFile.txt")).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                noneMatch(t -> t.contains("x"));
        System.out.println(b3);//false

        //Example 6: Type the code that counts words ending with "g" in the LambdaTextFile file.
        long count = Files.
                lines(Path.of("src/main/java/lambda/LambdaTextFile.txt")).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).filter(t -> t.endsWith("g")).count();
        System.out.println(count);//3
    }

    //Example 3: Create a method that shows whether any word in the LambdaTextFile file exists.
    public static boolean isExistAnyWord (String path, String word) throws IOException {
        return Files.
                lines(Path.of(path)).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                anyMatch(t -> t.contains(word));
    }


}