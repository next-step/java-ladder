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
	private static final int MIN_WORD_LENGTH = 12;
	private static final int MULTIPLE_NUMBER = 2;
	private static final int DEFAULT_NUMBER = 0;
	private static final int OVER_NUMBER = 3;

	public static long countWords() throws IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get("src/main/resources/fp/war-and-peace.txt")),
				StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		long count = words.stream()
				.filter(word -> word.length() > MIN_WORD_LENGTH)
				.count();
		return count;
	}
	
	public static void printLongestWordTop100() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		words.stream()
				.filter(word -> word.length() > MIN_WORD_LENGTH)
				.distinct()
				.sorted(Comparator.comparing(String::length))
				.forEach(w -> System.out.println(w.toLowerCase()));
	}

	public static List<Integer> doubleNumbers(List<Integer> numbers) {
		return numbers.stream()
				.map(x -> MULTIPLE_NUMBER * x)
				.collect(Collectors.toList());
	}

	public static long sumAll(List<Integer> numbers) {
		return numbers.stream()
				.reduce(DEFAULT_NUMBER, (x, y) -> x + y);
	}

	public static long sumOverThreeAndDouble(List<Integer> numbers) {
		return sumAll(doubleNumbers(numbers.stream()
				.filter(number -> number > OVER_NUMBER)
				.collect(Collectors.toList())));
	}
}