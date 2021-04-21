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

    public static List<String> exceedTwelveWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        return Arrays.asList(contents.split("[\\P{L}]+"));
    }

    public static long countWords(WordConditional c) throws IOException {
        return exceedTwelveWords().stream().filter(c::test).count();
    }

    public static void printLongestWordTop100() throws IOException {
        List<String> words = exceedTwelveWords();
        words.stream()
                .map(String::toLowerCase)
                .distinct()
                .sorted((x, y) -> Integer.compare(y.length(), x.length()))
                .collect(Collectors.toList())
                .subList(0, 99)
                .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        List<Integer> overThreeList = numbers.stream()
                .filter(x -> x > 3).collect(Collectors.toList());
        return sumAll(doubleNumbers(overThreeList));
    }
}
