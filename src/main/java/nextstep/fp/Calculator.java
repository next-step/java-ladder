package nextstep.fp;

import java.util.List;

public class Calculator {

	private static final Integer INIT_NUMBER = 0;

	public static Integer sumAllByCondition(List<Integer> numbers, Conditional conditional) {
		return numbers.stream()
						.filter(conditional::test)
						.reduce(INIT_NUMBER, Integer::sum);
	}
}
