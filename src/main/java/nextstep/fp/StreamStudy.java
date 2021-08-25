package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<String> longestWords = words.stream()
                .filter(word -> word.length() > 12)
                .sorted(sortByLength())
                .distinct()
                .collect(Collectors.toList());

        List<String> topWords = getTopWords(longestWords);
        topWords.forEach(System.out::println);

    }

    private static List<String> getTopWords(List<String> longestWords) {
        List<String> topWords = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            topWords.add(longestWords.get(i));
        }

        return topWords;
    }

    private static Comparator<String> sortByLength() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() == o2.length()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x > 3)
                .map(x -> 2 * x)
                .reduce(0, Integer::sum);
    }
}