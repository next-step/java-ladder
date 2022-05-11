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
        List<String> words = getWords();

        return words.stream()
                .filter(StreamStudy::lengthOver12)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        List<String> words = getWords();

        words.stream()
                .filter(StreamStudy::lengthOver12)
                .sorted(Comparator.comparing(String::length).reversed())
                .distinct()
                .limit(100)
                .forEach(StreamStudy::printLowerCase);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(StreamStudy::multiply2)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(StreamStudy::over3)
                .map(StreamStudy::multiply2)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private static List<String> getWords() throws IOException {
        String contents = Files.readString(Paths.get("src/main/resources/fp/war-and-peace.txt"));
        return Arrays.asList(contents.split("[\\P{L}]+"));
    }

    private static void printLowerCase(String s) {
        System.out.println(s.toLowerCase());
    }

    private static int multiply2(Integer integer) {
        return integer * 2;
    }

    private static boolean over3(Integer integer) {
        return integer > 3;
    }

    private static boolean lengthOver12(String w) {
        return w.length() > 12;
    }
}
