package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
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

//    단어의 길이가 12자를 초과하는 단어를 추출한다.
//    12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
//    단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
//    추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
    public static List<String> printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                    .filter(word -> word.length() > 12)
                    .distinct()
                    .limit(100)
                    .map(String::toLowerCase)
                    .sorted(Comparator.comparing(String::length).reversed())
                    .collect(Collectors.toList());
    }

    public static boolean numberCheck(String text) {
        boolean flag = text.matches("^[0-9]*$");

        return flag;
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {

        return numbers.stream()
                .filter(num -> num > 3)
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum) * 2;
    }
}