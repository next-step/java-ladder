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
        List<String> words = readFileAndGetWords();

        long count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        return count;
    }

    public static void printLongestWordTop100() throws IOException {
        String longestWordTop100 = readFileAndGetWords()
                .stream()
                .filter(word -> word.length() > 12)
                .map(String::toLowerCase)
                .distinct()
                .sorted((word1, word2) -> word2.length() - word1.length())
                .limit(100)
                .collect(Collectors.joining(","));

        System.out.print(longestWordTop100);
    }

    private static List<String> readFileAndGetWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);

        return Arrays.asList(contents.split("[\\P{L}]+"));
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