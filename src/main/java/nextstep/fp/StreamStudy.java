package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StreamStudy {

	public static long countWords() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		return words.stream().filter(w -> w.length() > 12).count();
	}
	
	public static void printLongestWordTopWithLimit(int minWordSize, int limitCount) throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		words.stream()
				.distinct()
				.filter(word -> word.length() > minWordSize)
				.sorted(comparing(String::length))
				.limit(limitCount)
				.map(String::toLowerCase)
				.forEach(System.out::println);
	}

	public static List<Integer> doubleNumbers(List<Integer> numbers) {
		return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
	}

	public static long sumAll(List<Integer> numbers) {
		return numbers.stream().reduce(0, (x, y) -> x + y);
	}

	public static long sumOverThreeAndDouble(List<Integer> numbers) {
		return numbers.stream()
				.filter(x -> x > 3)
				.map(x -> x * 2)
				.reduce(0, Integer::sum);
	}
}