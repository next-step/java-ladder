package nextstep.fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    public static final String FILE_FP_WAR_AND_PEACE_TXT = "src/main/resources/fp/war-and-peace.txt";
    public static final int WORD_LIMIT_SIZE = 12;
    public static final int WORD_LIMIT_PRINT = 100;

    private StreamStudy() {}

    public static long countWords() throws IOException {
        String contents = Files.readString(Paths
                .get(FILE_FP_WAR_AND_PEACE_TXT));
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .filter(word -> word.length() > WORD_LIMIT_SIZE)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = Files.readString(Paths
                .get(FILE_FP_WAR_AND_PEACE_TXT));
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        words.stream()
                .filter(word -> word.length() > WORD_LIMIT_SIZE)
                .sorted()
                .distinct()
                .limit(WORD_LIMIT_PRINT)
                .forEach(word -> System.out.println(word.toLowerCase()));
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

    public static long sumOverThreeAndDouble(final List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 3)
                .map(number -> 2 * number)
                .reduce(0, Integer::sum);
    }
}