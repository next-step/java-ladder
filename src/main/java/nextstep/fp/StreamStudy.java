package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamStudy {

    private static final String PATH = "src/main/resources/fp/war-and-peace.txt";

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(PATH)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        return words.stream()
                    .filter(w -> w.length() > 12)
                    .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(PATH)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));


        words.stream()
             .filter(v -> v.length() > 12) // 단어의 길이가 12자를 초과하는 단어를 추출한다.
             .distinct() // 단어 중복을 허용하지 않는다.
             .sorted((a, b) -> b.length() - a.length()) // 길이가 긴 순서
             .limit(100) // 100개의 단어를 추출한다.
             .map(String::toLowerCase) // 모든 단어는 소문자로 출력해야 한다.
             .forEach(System.out::println); // 추출한 100개의 단어를 출력한다.
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .map(x -> 2 * x)
                      .collect(toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, Math::addExact);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        // List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다
        return numbers.stream()
                      .filter(v -> v > 3)
                      .map(v -> v * 2)
                      .reduce(0, Math::addExact);
    }
}