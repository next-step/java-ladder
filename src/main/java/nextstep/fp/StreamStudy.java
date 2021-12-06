package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    public static long countWords() throws IOException {
        List<String> words = readFromFile("src/main/resources/fp/war-and-peace.txt");

        return words.stream()
                .filter(word -> word.length() > 12)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        List<String> words = readFromFile("src/main/resources/fp/war-and-peace.txt");

        words.stream()
                .filter(word -> word.length() > 12)
                .map(String::toLowerCase)
                .distinct()
                .limit(100)
                .sorted((w1, w2) -> w2.length() - w1.length())
                .forEach(System.out::println);
    }

    private static List<String> readFromFile(String path) throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get(path)), StandardCharsets.UTF_8);
        return Arrays.asList(contents.split("[\\P{L}]+"));
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 3)
                .map(x -> x * 2)
                .reduce(0, Integer::sum);
    }
}