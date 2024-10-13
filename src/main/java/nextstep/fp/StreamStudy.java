package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

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
        /*
        아래의 조건을 충족하는 단어를 출력
        - filter : 길이가 12자 초과
        - distinct : 중복 불가
        - limit : 100개 제한
        - sort : 단어 길이가 긴 순서대로
        - 출력 : 소문자로 출력
        */
        words.stream()
                .filter(word -> word.length() > 12)
                .distinct()
                .limit(100)
                .map(String::toLowerCase)
                .sorted(comparing(String::length).reversed())
                .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        //3보다 큰 수를 2배한 후 모든 값의 합
        return numbers.stream()
                .filter(number -> number > 3)
                .map(number -> number * 2)
                .reduce(0, Integer::sum);
    }
}