package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class StreamStudy {

    private static final int WORD_TOP_LIMIT = 100;
    private static final int LONG_WORD_CONDITION = 12;

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
        words.stream()
                .filter(word -> word.length() > LONG_WORD_CONDITION)
                .distinct()
                .sorted((word1, word2) -> word2.length() - (word1.length()))
                .limit(WORD_TOP_LIMIT)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return sumAll(numbers.stream()
        .filter(number -> number > 3)
        .map(number -> number * 2).collect(Collectors.toList()));
    }
}