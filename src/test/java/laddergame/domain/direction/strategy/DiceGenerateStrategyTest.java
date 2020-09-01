package laddergame.domain.direction.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import laddergame.domain.direction.Direction;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static laddergame.domain.direction.Direction.*;

class DiceGenerateStrategyTest {
	//생성자에 준 supplier가 고정값이므로 반환 되는 Direction은 조건에 맞는 것중 enum ordinal 순으로 첫번째 것
	private final DiceGenerateStrategy strategy = new DiceGenerateStrategy(() -> 1);

	@DisplayName("이전 방향에 따라서 다음에 올수 있는 Direction이 잘 나오는지 테스트")
	@ParameterizedTest
	@MethodSource("provide")
	void getNextDirection(Direction previous, Direction result) {
		assertThat(strategy.getNextDirection(previous)).isEqualTo(result);
	}

	@DisplayName("첫 Point에 쓸 Direction을 뽑을 때 전략에 맞는 값이 나오는지 테스트")
	@Test
	void getDirectionToStart() {
		assertThat(strategy.getDirectionToStart()).isEqualTo(RIGHT);
	}

	@DisplayName("이전 방향에 따라서 마지막 Point에 쓸 Direction이 잘 나오는지 테스트")
	@ParameterizedTest
	@MethodSource("provide2")
	void getDirectionToEnd(Direction previous, Direction result) {
		assertThat(strategy.getDirectionToEnd(previous)).isEqualTo(result);
	}

	static Stream<Arguments> provide() {
		return Stream.of(
				Arguments.of(RIGHT, LEFT),
				Arguments.of(LEFT, RIGHT),
				Arguments.of(DOWN, RIGHT)
		);
	}

	static Stream<Arguments> provide2() {
		return Stream.of(
				Arguments.of(RIGHT, LEFT),
				Arguments.of(LEFT, DOWN),
				Arguments.of(DOWN, DOWN)
		);
	}
}
