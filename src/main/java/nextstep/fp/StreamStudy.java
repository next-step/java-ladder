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
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .filter(word -> word.length() > 12)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        /**
         filter     - 단어의 길이가 12자를 초과하는 단어를 추출한다.
         distinct   - 단어 중복을 허용하지 않는다.
         limit      - 즉, 서로 다른 단어 100개를 추출해야 한다.
         sorted     - 길이가 긴 순서로 100개의 단어를 추출한다. Comparator.comparing.reversed 사용
         map        - 모든 단어는 소문자로 출력해야 한다. (String::toLowerCase)
         forEach    - 추출한 100개의 단어를 출력한다. (System.out::println)
         */
        words.stream()
            .filter(word -> word.length() > 12)
            .distinct()
            .limit(100)
            .sorted(Comparator.comparing(String::length).reversed())
            .map(String::toLowerCase)
            .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        List<Integer> overThreeNumbers = numbers.stream()
                .filter(number -> number > 3)
                .collect(Collectors.toList());
        return sumAll(doubleNumbers(overThreeNumbers));
    }
}