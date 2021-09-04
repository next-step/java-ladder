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
    private static final int MAX_SIZE = 100;
    private static final int MIN_VALUE = 3;
    private static final int MIN_LENGTH = 12;
    private static final int INIT_TOTAL_VALUE = 0;
    private static final int MULTIPLIED_VALUE = 2;

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .filter(w -> w.length() > MIN_LENGTH)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        words.stream()
                .filter(w -> w.length() > MIN_LENGTH)
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(MAX_SIZE)
                .forEach(s -> System.out.println(s.toLowerCase()));
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> MULTIPLIED_VALUE * x)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .reduce(INIT_TOTAL_VALUE, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num > MIN_VALUE)
                .map(num -> num * MULTIPLIED_VALUE)
                .reduce(INIT_TOTAL_VALUE, Integer::sum);
    }
}