package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineTest {
	public static Stream<Arguments> makeLineTestArguments() {
		return Stream.of(
				Arguments.arguments(4, 3),
				Arguments.arguments(5, 4)
		);
	}

	@ParameterizedTest
	@MethodSource("makeLineTestArguments")
	@DisplayName("유저 수를 이용해 생성된 Line의 사이즈는 유저 수보다 하나 작아야 한다.")
	void makeLineTest(int userCnt, int actualSize) {
		Line line = new Line(userCnt);
		assertEquals(line.getLine().size(), actualSize);
	}
}