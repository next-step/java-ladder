package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class StreamStudy {

    private static final String FILE_PATH = "src/main/resources/fp/war-and-peace.txt";
    private static final String SPLIT_PATTERN = "\\P{L}+";

    public static long countWords(Predicate<Integer> checkStringLength) throws IOException {
        String contents = Files.readString(Paths.get(FILE_PATH));
        List<String> words = Arrays.asList(contents.split(SPLIT_PATTERN));

        return words.stream()
                    .filter(word -> checkStringLength.test(word.length()))
                    .count();
    }

    public static void printLongestWordTop100(Predicate<Integer> checkStringLength) throws IOException {
        String contents = Files.readString(Paths.get(FILE_PATH));
        List<String> words = Arrays.asList(contents.split(SPLIT_PATTERN));

        words.stream()
             .filter(word -> checkStringLength.test(word.length()))
             .sorted(comparingInt(String::length).reversed())
             .distinct()
             .limit(100)
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
                      .reduce(0, Integer::sum) * 2;
    }
}