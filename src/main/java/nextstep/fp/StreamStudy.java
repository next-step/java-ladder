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

	// 요구사항은 파일 문자 중 길이가 12보다 큰 문자의 수를 구한다.
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

	/*
	단어의 길이가 12자를 초과하는 단어를 추출한다.
	12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
	단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
	추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
	 */
	public static void printLongestWordTop100() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		List<String> wordTop100 = words.stream()
				.filter(word -> word.length() > 12)
				.sorted(Comparator.comparing(String::length).reversed())
				.distinct()
				.map(word -> word.toLowerCase())
				.limit(100)
				.collect(Collectors.toList());

		System.out.println(wordTop100);
	}

	// List에 담긴 모든 숫자 값을 2배한 결과 List를 생성한다.
	public static List<Integer> doubleNumbers(List<Integer> numbers) {
		return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
	}

	// List에 담긴 모든 숫자의 합을 구한다.
	public static long sumAll(List<Integer> numbers) {
		return numbers.stream().reduce(0, (x, y) -> x + y);
	}

	// List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다. 지금까지 학습한 map, reduce, filter를 활용해 구현해야 한다.
	public static long sumOverThreeAndDouble(List<Integer> numbers) {
		return numbers.stream()
				.filter(x -> x > 3)
				.map(x -> x * 2)
				.reduce(0, (x, y) -> x + y);
	}
}