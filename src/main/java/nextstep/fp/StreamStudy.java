package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamStudy {
    private static int MINIMUM_PRINT_WORD_LENGTH = 12;
    private static long MAXIMUM_PRINT_SIZE = 100;

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        return count;
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        words.stream()
                .filter(longerThanMinimumWordLength())
                .distinct()
                .sorted(sortByStringLengthInDescendingOrder())
                .limit(MAXIMUM_PRINT_SIZE)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    private static Predicate<String> longerThanMinimumWordLength() {
        return word -> word.length() > MINIMUM_PRINT_WORD_LENGTH;
    }

    private static Comparator<String> sortByStringLengthInDescendingOrder() {
        return Comparator.comparingInt(String::length).reversed();
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 3)
                .map(number -> number * 2)
                .reduce(Integer::sum)
                .orElse(0);
    }
}