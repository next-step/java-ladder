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
        String contents = new String(Files.readAllBytes(Paths
            .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                    .filter(w -> w.length() > 12)
                    .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
            .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        words.stream()
             .filter(w -> w.length() > 12)
             .sorted((s1, s2) -> s2.length() - s1.length())
             .distinct()
             .forEach(s -> System.out.println(s.toLowerCase()));
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                      .reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                      .filter(n -> n > 3)
                      .map(n -> n * 2)
                      .reduce(Integer::sum)
                      .orElse(0);
    }
}
