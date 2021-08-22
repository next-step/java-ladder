package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
            .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        String[] words = contents.split("[\\P{L}]+");

        long count = 0;
        for (String w : words) {
            if (w.length() > 12) {
                count++;
            }
        }
        return count;
    }

    /**
     * 단어의 길이가 12자를 초과하는 단어를 추출한다. 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다. 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다. 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로
     * 출력해야 한다.
     *
     * @throws IOException
     */
    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
            .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // TODO 이 부분에 구현한다.
        words.stream()
            .filter(s -> s.length() > 12)
            .sorted((o1, o2) -> Integer.compare(o2.length(), o1.length()))
            .limit(100)
            .distinct()
            .forEach(s -> System.out.println(s.toLowerCase(Locale.ROOT)));
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
            .filter(integer -> integer > 3)
            .mapToLong(integer -> integer * 2)
            .reduce(Long::sum)
            .orElseThrow(() -> new IllegalArgumentException("numbers is empty"));
    }
}