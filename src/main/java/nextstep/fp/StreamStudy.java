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
    private static final String RESOURCE = "src/main/resources/fp/war-and-peace.txt";
    private static final String WORD_SPLIT_PATTERN = "[\\P{L}]+";

    public static long countWords() {
        List<String> words = splitByPatten(readFromResourceFile(), WORD_SPLIT_PATTERN);

        return words
                .stream()
                .filter(s -> 12 < s.length())
                .count();
    }

    public static void printLongestWordTop100() {
        List<String> words = splitByPatten(readFromResourceFile(), WORD_SPLIT_PATTERN);

        words.stream()
                .map(String::toLowerCase)
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(100)
                .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .map(x -> 2 * x)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(n -> 3 < n)
                .mapToInt(n -> 2 * n)
                .sum();
    }

    private static String readFromResourceFile() {
        try {
            return new String(
                    Files.readAllBytes(Paths.get(RESOURCE)),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException("파일을 읽어오는데 실패하였습니다");
        }
    }

    private static List<String> splitByPatten(String content, String pattern) {
        return Arrays.asList(content.split(pattern));
    }
}