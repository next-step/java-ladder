package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.LineFactory;
import nextstep.ladder.fixture.RightOnlyPointsStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @ParameterizedTest(name = "[{index}] startPosition={0}, expectedPosition={1}, Lines={2}")
    @MethodSource("lineMoveFixture")
    @DisplayName("[성공] 라인의 좌표 정보를 기반으로 위치를 이동시킨다.")
    void 라인_이동(int startPosition, int expectedPosition, List<Boolean> rightPoints) {
        Line line = LineFactory.of(new RightOnlyPointsStrategy(), rightPoints);
        assertThat(line.move(startPosition)).isEqualTo(expectedPosition);
    }

    static Stream<Arguments> lineMoveFixture() {
        return Stream.of(
                Arguments.of(0, 1, List.of(true, false, true)),
                Arguments.of(0, 0, List.of(false, false, true)),

                Arguments.of(1, 0, List.of(true, false, true)),
                Arguments.of(1, 1, List.of(false, false, false)),
                Arguments.of(1, 2, List.of(false, true, false)),

                Arguments.of(2, 1, List.of(false, true, false)),
                Arguments.of(2, 2, List.of(false, false, false))
        );
    }

}
