package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    private StreamStudy() {
    }

    public static long countWords() throws IOException {
        List<String> words = getStrings();
        return words.stream()
                .filter(s -> s.length() > 12)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        List<String> words = getStrings();
        words.stream()
                .filter(s -> s.length() > 12)
                .distinct()
                .limit(100)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .map(String::toLowerCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer > 3)
                .mapToInt(integer -> integer * 2)
                .sum();
    }

    private static List<String> getStrings() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        return Arrays.asList(contents.split("[\\P{L}]+"));
    }
}