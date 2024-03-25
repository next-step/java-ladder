package nextstep.fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = Files.readString(Paths.get("src/main/resources/fp/war-and-peace.txt"));
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .filter(word -> word.length() > 12)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = Files.readString(Paths.get("src/main/resources/fp/war-and-peace.txt"));
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        AtomicInteger index = new AtomicInteger(0);
        StringBuilder stringBuilder = new StringBuilder();
        words.stream()
                .filter(word -> word.length() > 12)
                .sorted(Comparator.comparing(String::length).reversed())
                .distinct()
                .limit(100)
                .forEach(getStringConsumer(index, stringBuilder));
        System.out.println(stringBuilder);
    }

    private static Consumer<String> getStringConsumer(AtomicInteger index, StringBuilder stringBuilder) {
        return word -> stringBuilder
                .append(String.format("%03d. %s", index.incrementAndGet(), word))
                .append(System.lineSeparator());
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 3)
                .mapToLong(Long::valueOf)
                .map(number -> number * 2)
                .reduce(0, Long::sum);
    }
}