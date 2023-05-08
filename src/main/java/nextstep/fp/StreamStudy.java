package nextstep.fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {
    private static final int DOUBLE = 2;
    private static final int ZERO = 0;
    private static final int NUMBER_CONDITION = 3;
    private static final int LENGTH_CONDITION = 12;
    private static final int LONGEST_LIMIT = 100;
    private static final String READ_FILE = "src/main/resources/fp/war-and-peace.txt";
    private static final String FILE_SPLIT_REGEX = "[\\P{L}]+";

    public static long countWords() throws IOException {
        List<String> words = readFile();

        return words.stream()
                .filter(w -> w.length() > LENGTH_CONDITION)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        List<String> words = readFile();

        words = removeDuplicateWord(words);

        words.stream()
                .filter(StreamStudy::filterLongestWordOver12)
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(LONGEST_LIMIT)
                .forEach(System.out::println);
    }

    private static List<String> readFile() throws IOException {
        String contents = Files.readString(Paths.get(READ_FILE));
        return Arrays.asList(contents.split(FILE_SPLIT_REGEX));
    }

    private static List<String> removeDuplicateWord(List<String> requestWords) {
        return requestWords.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static boolean filterLongestWordOver12(String requestWord) {
        return requestWord.length() >= LENGTH_CONDITION;
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(StreamStudy::multiplyDouble)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .reduce(ZERO, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > NUMBER_CONDITION)
                .map(StreamStudy::multiplyDouble)
                .reduce(ZERO, Integer::sum);
    }

    private static int multiplyDouble(int number) {
        return number * DOUBLE;
    }

}