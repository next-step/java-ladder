package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ladder.domain.line.Line;

public class LadderPieceTest {

	@ParameterizedTest
	@MethodSource("ladderPieceProvider")
	public void ladderPieceTest(int position, int expect) {
		assertThat(position).isEqualTo(expect);

	}

	private static Stream<Arguments> ladderPieceProvider() {
		Line line = Line.of(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));

		return Stream.of(
				Arguments.arguments(line.move(0), 1),
				Arguments.arguments(line.move(1), 0),
				Arguments.arguments(line.move(2), 3),
				Arguments.arguments(line.move(3), 2)
						);
	}
}
