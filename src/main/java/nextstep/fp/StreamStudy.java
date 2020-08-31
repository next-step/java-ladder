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

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                                                            .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        return getWords(contents).stream().filter(w -> w.length() > 12).count();
    }

    private static List<String> getWords(String contents) {
        return Arrays.asList(contents.split("[\\P{L}]+"));
    }

    public static List<String> printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                                                            .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);

        return getWords(contents).stream()
                                 .filter(word -> word.length() > 12)
                                 .sorted(Comparator.comparing(String::length).reversed())
                                 .distinct()
                                 .limit(100)
                                 .map(word -> word.toLowerCase())
                                 .collect(Collectors.toList());
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                      .filter(n -> 3 < n)
                      .map(n -> n * 2)
                      .mapToInt(Integer::intValue)
                      .sum();
    }
}