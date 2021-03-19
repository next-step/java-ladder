package nextstep.ladder.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositionTest {

	@ParameterizedTest
	@DisplayName("오른쪽으로 무빙")
	@CsvSource(value = {"1,2", "2,3", "3,4"}, delimiter = ',')
	void move_right(int input, int expected) {
		// given
		Root root = new Root(() -> true);

		// when
		Position position = new Position(input);

		// then
		assertThat(position.move(root, input).getPosition())
			.isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("왼쪽으로 무빙")
	@CsvSource(value = {"1,0", "2,1", "3,2"}, delimiter = ',')
	void move_left(int input, int expected) {
		// given
		Root root = new Root(() -> true);

		// when
		Position position = new Position(input);

		// then
		assertThat(position.move(root, input - 1).getPosition())
			.isEqualTo(expected);
	}
}
