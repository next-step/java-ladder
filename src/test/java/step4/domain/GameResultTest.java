package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
	private static Stream<Arguments> provideGameResultsSize() {
		return Stream.of(
				Arguments.of(new String[] {"dami", "mong", "123", "hi"},
							new String[] {"10", "0", "1000", "5000"}, 4),

				Arguments.of(new String[] {"aaa", "bbb", "ccc", "ddd", "eee"},
							new String[] {"꽝", "꽝", "꽝", "1000", "2000"}, 5),

				Arguments.of(new String[] {"DAMI", "MONG", "COR"},
							new String[] {"1000", "10", "50"}, 3),

				Arguments.of(new String[] {"ABC", "DEF"},
							new String[] {"꽝", "당첨"}, 2),

				Arguments.of(new String[] {"dam", "corgi", "welsh", "mong"},
							new String[] {"4", "3", "2", "1"}, 4)
		);
	}

	@DisplayName(value = "게임 결과 초기화 확인")
	@ParameterizedTest
	@MethodSource("provideGameResultsSize")
	void gameResultSize(String[] names, String[] results, int size) {
		GameResult result = GameResult.init(names, results);
		assertThat(result.size()).isEqualTo(size);
	}

	private static Stream<Arguments> provideGameResults() {
		return Stream.of(
				Arguments.of(new String[] {"dami", "mong", "123", "hi"},
							new String[] {"10", "0", "1000", "5000"}, "mong", "0"),

				Arguments.of(new String[] {"aaa", "bbb", "ccc", "ddd", "eee"},
							new String[] {"꽝", "꽝", "꽝", "1000", "2000"}, "eee", "2000"),

				Arguments.of(new String[] {"DAMI", "MONG", "COR"},
							new String[] {"1000", "10", "50"}, "DAMI", "1000"),

				Arguments.of(new String[] {"ABC", "DEF"},
							new String[] {"꽝", "당첨"}, "DEF", "당첨"),

				Arguments.of(new String[] {"dam", "corgi", "welsh", "mong"},
							new String[] {"4", "3", "2", "1"}, "welsh", "2")
		);
	}

	@DisplayName(value = "입력한 이름의 결과 값 반환 테스트")
	@ParameterizedTest
	@MethodSource("provideGameResults")
	void gameResultOfIndex(String[] names, String[] results, String name, String expectedResult) {
		GameResult result = GameResult.init(names, results);
		result.putAll(Arrays.asList(names.clone()), Arrays.asList(results.clone()));
		assertThat(result.getResultOf(name)).isEqualTo(expectedResult);
	}
}
