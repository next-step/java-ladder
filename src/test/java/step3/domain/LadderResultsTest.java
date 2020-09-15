package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {
	private static Stream<Arguments> provideGameResultsSize() {
		return Stream.of(
				Arguments.of(new String[] {"10", "0", "1000", "5000"}, 4),
				Arguments.of(new String[] {"꽝", "꽝", "꽝", "1000", "2000"}, 5),
				Arguments.of(new String[] {"1000", "10", "50"}, 3),
				Arguments.of(new String[] {"꽝", "당첨"}, 2),
				Arguments.of(new String[] {"4", "3", "2", "1"}, 4)
		);
	}

	@DisplayName(value = "생성한 게임 결과 사이즈 테스트")
	@ParameterizedTest
	@MethodSource("provideGameResultsSize")
	void gameResultSize(String[] result, int size) {
		GameResults results = GameResults.of(result);
		assertThat(results.size()).isEqualTo(size);
	}

	private static Stream<Arguments> provideGameResults() {
		return Stream.of(
				Arguments.of(new String[] {"10", "0", "1000", "5000"}, 1, "0"),
				Arguments.of(new String[] {"꽝", "꽝", "꽝", "1000", "2000"}, 4, "2000"),
				Arguments.of(new String[] {"1000", "10", "50"}, 0, "1000"),
				Arguments.of(new String[] {"꽝", "당첨"}, 1, "당첨"),
				Arguments.of(new String[] {"4", "3", "2", "1"}, 2, "2")
		);
	}

	@DisplayName(value = "입력한 인덱스 위치에 있는 결과 값 반환 테스트")
	@ParameterizedTest
	@MethodSource("provideGameResults")
	void gameResultOfIndex(String[] result, int index, String expectedResult) {
		GameResults results = GameResults.of(result);
		assertThat(results.getResultOf(index)).isEqualTo(expectedResult);
	}
}
