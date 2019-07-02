package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

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

        // TODO 이 부분에 구현한다.
        List<String> filterWords = words.stream().filter(w -> w.length() > 12).collect(Collectors.toList());
        List<String> toLowerCaseWords = filterWords.stream().map(String::toLowerCase).collect(Collectors.toList());
        List<String > distinctWords = toLowerCaseWords.stream().distinct().collect(Collectors.toList());
        List<String> sortedWords = distinctWords.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());

        sortedWords.stream().limit(100).forEach(System.out::println);

    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        List<Integer> filterNumbers = numbers.stream().filter(w -> w.longValue() > 3).collect(Collectors.toList());
        List<Integer> doubleNumbers = doubleNumbers(filterNumbers);
        long result = sumAll(doubleNumbers);
        return result;
    }
}