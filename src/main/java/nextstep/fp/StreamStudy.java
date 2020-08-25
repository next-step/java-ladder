package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    private static final int NUMBER_TWELVE = 12;
    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_THREE = 3;
    private static final int NUMBER_HUNDRED = 100;

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .filter(word -> word.length() > NUMBER_TWELVE)
                .count();
    }

    public static List<String> printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .filter(word -> word.length() > NUMBER_TWELVE)
                .sorted(Comparator.comparing(String::length).reversed())
                .distinct()
                .limit(NUMBER_HUNDRED)
                .map(word -> word.toLowerCase())
                .collect(Collectors.toList());
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> NUMBER_TWO * x)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .reduce(NUMBER_ZERO, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > NUMBER_THREE)
                .map(number -> number * NUMBER_TWO )
                .reduce(NUMBER_ZERO, (x, y) -> x + y);
    }

}
