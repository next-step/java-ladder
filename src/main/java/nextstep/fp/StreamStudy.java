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

    public static final int TWELVE = 12;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int ZERO = 0;
    public static final int MAX_SIZE = 100;

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .filter(StreamStudy::isWordLengthOverTwelve)
                .count();
    }

    private static boolean isWordLengthOverTwelve(String word) {
        return word.length() > TWELVE;
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        words.stream()
                .distinct()
                .filter(StreamStudy::isWordLengthOverTwelve)
                .sorted(orderByLengthDesc())
                .limit(MAX_SIZE)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    private static Comparator<String> orderByLengthDesc() {
        return Comparator.comparing(String::length)
                .reversed();
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(StreamStudy::multiplyByTwo)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .reduce(ZERO, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(StreamStudy::isOverThree)
                .map(StreamStudy::multiplyByTwo)
                .reduce(ZERO, Integer::sum);
    }

    private static boolean isOverThree(Integer n) {
        return n > THREE;
    }

    private static int multiplyByTwo(Integer n) {
        return TWO * n;
    }
}