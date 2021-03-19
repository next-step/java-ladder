package nextstep.ladder.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtils {
	private static final String numericRegex = "^[0-9]+";

	public static boolean isNumeric(String word) {
		return word.matches(numericRegex);
	}

	public static String joining(String... input) {
		return Arrays.stream(input)
			.collect(Collectors.joining(""));
	}
}
