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

    public static final String FILE_PATH = "src/main/resources/fp/war-and-peace.txt";
    public static final String SPLIT_PATTERN = "[\\P{L}]+";

    public static long countWords() throws IOException {
        List<String> words = splitByPatten(readFromFile(), SPLIT_PATTERN);
        return words.stream()
                .filter(word -> word.length() > 12)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        List<String> words = splitByPatten(readFromFile(), SPLIT_PATTERN);
        words.stream()
                .filter(word -> word.length() > 12)
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(100)
                .distinct()
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> 2 * x)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 3)
                .mapToInt(number -> number * 2)
                .sum();
    }


    private static List<String> splitByPatten(String text, String pattern) {
        return Arrays.asList(text.split(pattern));
    }

    private static String readFromFile() {
        try {
            return new String(
                    Files.readAllBytes(Paths.get(FILE_PATH)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException("파일을 읽는데 실패하였습니다.");
        }
    }

}
