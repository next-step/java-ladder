package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudy {

	public static long countWords() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);

		return split(contents)
				.filter(isOverLength(12))
				.count();
	}

	private static Stream<String> split(final String words) {
		return Arrays.stream(words.split("[\\P{L}]+"));
	}

	public static void printLongestWordTop100() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);

		split(contents)
				.filter(isOverLength(100))
				.sorted()
				.distinct()
				.limit(100)
				.map(String::toLowerCase)
				.forEach(System.out::println);
	}

	private static Predicate<String> isOverLength(final int length) {
		return word -> word.length() > length;
	}

	public static List<Integer> doubleNumbers(List<Integer> numbers) {
		return numbers.stream()
				.map(StreamStudy::doubleNumber)
				.collect(Collectors.toList());
	}

	private static boolean isOverThree(final int number) {
		return number > 3;
	}

	private static int doubleNumber(final int number) {
		return number * 2;
	}

	public static long sumAll(List<Integer> numbers) {
		return numbers.stream().reduce(0, Integer::sum);
	}

	public static long sumOverThreeAndDouble(List<Integer> numbers) {
		return numbers.stream()
				.filter(StreamStudy::isOverThree)
				.mapToInt(StreamStudy::doubleNumber)
				.sum();
	}
}