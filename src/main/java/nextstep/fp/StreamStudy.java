package nextstep.fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

  private static final String contents;

  static {
    try {
      contents = Files.readString(Paths.get("src/main/resources/fp/war-and-peace.txt"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static long countWords() {
    List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
    return words.stream()
        .filter(word -> word.length() > 12)
        .count();
  }

  public static Collection<String> printLongestWordTop100() {
    List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
    return words.stream()
        .filter(word -> word.length() > 12)
        .map(String::toLowerCase)
        .distinct()
        .limit(100)
        .sorted(Comparator.comparingInt(String::length))
        .collect(Collectors.toList());
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
        .map(number -> (long) number * 2)
        .reduce(0L, Long::sum);
  }
}
