package ladder.domain.line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineGenerator {

	public static final int MIN_LINE_COUNT = 1;

	private static Boolean bool;

	private LineGenerator(){
		throw new IllegalStateException();
	}

	public static List<Boolean> generate(int count) {
		validateLineCount(count);
		return IntStream.range(0, count)
		                .mapToObj(i -> next())
		                .collect(Collectors.toList());
	}

	private static void validateLineCount(int count) {
		if (count < MIN_LINE_COUNT) {
			throw new LineCountException();
		}
	}

	private static Boolean next() {
		bool = isTrue();
		return bool;
	}

	private static boolean isTrue() {
		if (Boolean.TRUE.equals(bool)) {
			return false;
		}
		return RandomBoolGenerator.generate();
	}

}
