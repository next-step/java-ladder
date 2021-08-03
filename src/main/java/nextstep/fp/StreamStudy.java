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
    private static final String DEFAULT_FILE_PATH = "src/main/resources/fp/war-and-peace.txt";
    private static final String WORD_REGEX = "[\\P{L}]+";

    public static long countWords() {
        return loadWords().size();
    }

    public static void printLongestWordTop100() {
        loadWords().stream()
                .map(String::toLowerCase)
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(100)
                .forEach(System.out::println);
    }

    private static List<String> loadWords() {
        String contents;
        try {
            contents = new String(
                    Files.readAllBytes(Paths.get(StreamStudy.DEFAULT_FILE_PATH)),
                    StandardCharsets.UTF_8
            );
        } catch (IOException e) {
            throw new RuntimeException("파일을 불러오지 못했습니다.");
        }
        return Arrays.stream(contents.split(WORD_REGEX))
                .filter(StreamStudy::isIncludeWord)
                .collect(Collectors.toList());
    }

    private static Boolean isIncludeWord(String word) {
        return word.length() > 12;
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(iNumber -> iNumber)
                .filter(iNumber -> iNumber > 3)
                .map(iNumber -> iNumber * 2)
                .sum();
    }
}