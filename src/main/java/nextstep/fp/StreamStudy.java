package nextstep.fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = Files.readString(Paths.get("src/main/resources/fp/war-and-peace.txt"));
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .filter(word -> word.length() > 12)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = Files.readString(Paths.get("src/main/resources/fp/war-and-peace.txt"));
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        List<String> longestWordTop100 = words.stream()
                .filter(word -> word.length() > 12)
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        longestWordTop100.forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        List<Integer> overThreeAndDoubleNumbers = numbers.stream()
                .filter(number -> number > 3)
                .map(number -> number * 2)
                .collect(Collectors.toList());

        return sumAll(overThreeAndDoubleNumbers);
    }
}