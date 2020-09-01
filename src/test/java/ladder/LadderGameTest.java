package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;

public class LadderGameTest {

	@ParameterizedTest
	@MethodSource("ladderGameProvider")
	public void ladderGameTest(int actual, int expect) {
		assertThat(actual).isEqualTo(expect);
	}

	private static Stream<Arguments> ladderGameProvider() {
		Line line1 = Line.of(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		Line line2 = Line.of(Arrays.asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
		Line line3 = Line.of(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		Line line4 = Line.of(Arrays.asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
		Line line5 = Line.of(Arrays.asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
		Ladder ladder = Ladder.of(Arrays.asList(line1, line2, line3, line4, line5));

		return Stream.of(
				Arguments.arguments(ladder.play(0), 3),
				Arguments.arguments(ladder.play(1), 1),
				Arguments.arguments(ladder.play(2), 2),
				Arguments.arguments(ladder.play(3), 0),
				Arguments.arguments(ladder.play(4), 4)
						);
	}
}
