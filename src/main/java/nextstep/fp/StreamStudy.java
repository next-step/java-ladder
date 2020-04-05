package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        return count;
    }

    public static long countWordsStream() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long count = words.stream().filter(word -> word.length() > 12).count();

        return count;
    }

    public static List<String> printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        List<String> over12lengthList = words.stream()
                .filter(word -> word.length() > 12)
                .collect(Collectors.toList());

        List<String> sortedReverseLengthList = over12lengthList
                .stream()
                .sorted((s1, s2) -> -1 * Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());

        List<String> discinctList = sortedReverseLengthList
                .stream()
                .distinct()
                .collect(Collectors.toList());

        List<String> lower100List = discinctList
                .stream()
                .limit(100)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        return lower100List;
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {

        List<Integer> overThreeList = numbers.stream().filter(number -> number > 3).collect(Collectors.toList());
        List<Integer> doubleList = overThreeList.stream().map(x -> x * 2).collect(Collectors.toList());
        long sum = doubleList.stream().reduce((x, y) -> x+y).orElse(0);

        return sum;
    }
}