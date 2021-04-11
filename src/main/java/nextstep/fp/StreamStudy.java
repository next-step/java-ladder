package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class StreamStudy {

    public static final String WAR_AND_PEACE_PATH = "src/main/resources/fp/war-and-peace.txt";
    public static final String REGEX = "[\\P{L}]+";

    public static final int ZERO = 0;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int TWELVE = 12;
    public static final int MAX_SIZE = 100;

    public static final long countWords() throws IOException {
        String contents = getContents();
        List<String> words = getWords(contents);

        return words.stream()
                .filter(word -> word.length() > TWELVE)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = getContents();
        List<String> words = getWords(contents);

        // TODO 이 부분에 구현한다.
        words.stream()
                .filter(word -> word.length() > TWELVE)
                .sorted()
                .distinct()
                .limit(MAX_SIZE)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    private static final List<String> getWords(String contents) {
        return Arrays.asList(contents.split(REGEX));
    }

    private static final String getContents() throws IOException {
        return new String(Files.readAllBytes(Paths
                .get(WAR_AND_PEACE_PATH)), StandardCharsets.UTF_8);
    }

    public static final List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> TWO * x).collect(Collectors.toList());
    }

    public static final long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(ZERO, (x, y) -> x + y);
    }

    public static final long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > THREE)
                .map(number -> number * TWO)
                .reduce(ZERO, (x, y) -> x + y);
    }
}