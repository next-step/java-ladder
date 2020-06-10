package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderLinePointsTest {

	@DisplayName("LadderLinePoints 생성 테스트")
	@Test
	void of() {
		List<LadderLinePoint> points = Arrays.asList(
				LadderLinePoint.of(true),
				LadderLinePoint.of(false),
				LadderLinePoint.of(true),
				LadderLinePoint.of(false));

		LadderLinePoints ladderLinePoints = LadderLinePoints.of(points);

		assertThat(ladderLinePoints.size()).isEqualTo(4);
	}

	@DisplayName("마지막 좌표가 다음 좌표와 연결되어 있으면 IllegalArgumentException")
	@Test
	void lastPointIsConnectedToNext() {
		List<LadderLinePoint> points = Arrays.asList(
				LadderLinePoint.of(true),
				LadderLinePoint.of(false),
				LadderLinePoint.of(true),
				LadderLinePoint.of(false),
				LadderLinePoint.of(true));

		assertThatThrownBy(() -> LadderLinePoints.of(points))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("마지막 좌표");
	}

	@DisplayName("좌표가 연속으로 연결되어 있으면 IllegalArgumentException")
	@ParameterizedTest
	@MethodSource("continuouslyConnectedPointsArguments")
	void continuouslyConnectedPoints(List<LadderLinePoint> points) {
		assertThatThrownBy(() -> LadderLinePoints.of(points))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("연속으로 연결");
	}

	public static Stream<Arguments> continuouslyConnectedPointsArguments() {
		return Stream.of(
				Arguments.of(Arrays.asList(
						LadderLinePoint.of(true),
						LadderLinePoint.of(true),
						LadderLinePoint.of(false))),

				Arguments.of(Arrays.asList(
						LadderLinePoint.of(true),
						LadderLinePoint.of(true),
						LadderLinePoint.of(false),
						LadderLinePoint.of(false),
						LadderLinePoint.of(false),
						LadderLinePoint.of(false))));
	}
}
