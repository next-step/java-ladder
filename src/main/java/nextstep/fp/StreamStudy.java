package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class StreamStudy {

    private final static int WORD_MAX = 100;
    private final static int WORD_MINIMUM_LENGTH = 12;

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

    public static List<String> printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        Set<String> wordsSet = words.stream()
                .filter(word -> word.length() > WORD_MINIMUM_LENGTH)
                .map(String::toLowerCase).sorted()
                .distinct()
                .limit(WORD_MAX)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        return words.stream()
                .filter(word -> word.length() > WORD_MINIMUM_LENGTH)
                .map(String::toLowerCase).sorted()
                .distinct()
                .limit(WORD_MAX)
                .collect(Collectors.toList());
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num > 3)
                .map(num -> num * 2)
                .reduce(0, Integer::sum);
    }
}