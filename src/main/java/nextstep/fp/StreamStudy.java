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
        String contents = Files.readString(Paths
                .get("src/main/resources/fp/war-and-peace.txt"));
        String[] words = contents.split("\\P{L}+");

        long count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        return count;
    }

    public static List<String> printLongestWordTop100() throws IOException {
        String contents = Files.readString(Paths
                .get("src/main/resources/fp/war-and-peace.txt"));
        List<String> words = Arrays.asList(contents.split("\\P{L}+"));

        // TODO 이 부분에 구현한다.
        List<String> longestWords = words.stream()
                .map(String::toLowerCase)
                .distinct()
                .filter(w -> w.length() > 12)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(100)
                .collect(Collectors.toList());
        longestWords.forEach(System.out::println);
        return longestWords;
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 3)
                .map(x -> x * 2)
                .reduce(0, Integer::sum);
    }
}