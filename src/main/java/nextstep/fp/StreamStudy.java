package nextstep.fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {
    private static final Integer MAX_WORDS_SIZE = 12;
    private static final Integer MAX_PRINT_SIZE = 100;

    public static long countWords() throws IOException {
        String contents = Files.readString(Paths
                .get("src/main/resources/fp/war-and-peace.txt"));
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .filter(word -> word.length() > 12)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = Files.readString(Paths
                .get("src/main/resources/fp/war-and-peace.txt"));
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // TODO 이 부분에 구현한다.
        words.stream()
                .distinct()
                .filter(w -> w.length() > MAX_WORDS_SIZE)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(MAX_PRINT_SIZE)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> 2 * x)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 3)
                .mapToInt(number -> 2 * number)
                .sum();
    }
}
