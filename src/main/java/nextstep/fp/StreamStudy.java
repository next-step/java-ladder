package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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
	
	public static void printLongestWordTop100() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		// TODO 이 부분에 구현한다.
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