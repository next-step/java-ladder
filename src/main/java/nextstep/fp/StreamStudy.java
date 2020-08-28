package nextstep.fp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamStudy {
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final String FILE_PATH = "src/main/resources/fp/war-and-peace.txt";
    private static final String REGEX = "[\\P{L}]+";
    private static final int ZERO_NUMBER = 0;
    private static final int MULTIPLICATION_NUMBER = 2;
    private static final int NUMBER_CONDITION = 3;
    private static final int LENGTH_CONDITION = 12;
    private static final int LIMIT_SIZE = 100;

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(FILE_PATH)), CHARSET);
        List<String> words = Arrays.asList(contents.split(REGEX));

        return words.stream()
                .filter(word -> word.length() > LENGTH_CONDITION)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(FILE_PATH)), CHARSET);
        List<String> words = Arrays.asList(contents.split(REGEX));

        words.stream()
            .filter(word -> word.length() > LENGTH_CONDITION)
            .sorted(Comparator.comparing(String::length).reversed())
            .distinct()
            .limit(LIMIT_SIZE)
            .map(String::toLowerCase)
            .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> MULTIPLICATION_NUMBER * x)
                .collect(toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .reduce(ZERO_NUMBER, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > NUMBER_CONDITION)
                .map(number -> number * MULTIPLICATION_NUMBER)
                .reduce(ZERO_NUMBER, Integer::sum);
    }
}