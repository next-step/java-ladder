package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .filter(StreamStudy::isLongerThanTwelve)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        int maxSize = 100;

        words.stream()
                .distinct()
                .filter(StreamStudy::isLongerThanTwelve)
                .sorted(comparing(String::length).reversed())
                .limit(maxSize)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    private static boolean isLongerThanTwelve(final String word) {
        return word.length() > 12;
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return doubleNumbers(numbers, number -> true);
    }

    private static List<Integer> doubleNumbers(List<Integer> numbers, Conditional conditional) {
        return numbers.stream()
                .filter(conditional::test)
                .map(x -> 2 * x)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return sumAll(doubleNumbers(numbers, number -> number > 3));
    }
}