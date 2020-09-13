package nextstep.domain;

import nextstep.domain.line.LineFactory;
import nextstep.domain.line.Lines;
import nextstep.domain.line.strategy.SwitchDrawTransverseBarStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("라인들")
public class LinesTest {

    @DisplayName("생성")
    @Test
    public void create() {
        Lines lines = new Lines(LineFactory.createLines(5, 3, new SwitchDrawTransverseBarStrategy()));
        assertThat(lines.getLines()).hasSize(3);
    }

    @DisplayName("왼쪽으로 갈수 있는지 확인")
    @ParameterizedTest
    @MethodSource("isPossibleMoveLeftTrackMethod")
    public void isPossibleMoveLeftTrack(int lineNumber, int trackNumber, boolean result) {
        Lines lines = new Lines(LineFactory.createLines(5, 3, new SwitchDrawTransverseBarStrategy()));
        assertThat(lines.isPossibleMoveLeftTrack(lineNumber, trackNumber)).isEqualTo(result);
    }

    private static Stream<Arguments> isPossibleMoveLeftTrackMethod() {
        return Stream.of(
                Arguments.of(0, 1, true),
                Arguments.of(0, 2, false),
                Arguments.of(0, 3, true),
                Arguments.of(0, 4, false)
        );
    }

    @DisplayName("오른쪽으로 갈수 있는지 확인")
    @ParameterizedTest
    @MethodSource("isPossibleMoveRightTrackMethod")
    public void isPossibleMoveRightTrack(int lineNumber, int trackNumber, boolean result) {
        Lines lines = new Lines(LineFactory.createLines(5, 3, new SwitchDrawTransverseBarStrategy()));
        assertThat(lines.isPossibleMoveRightTrack(lineNumber, trackNumber)).isEqualTo(result);
    }

    private static Stream<Arguments> isPossibleMoveRightTrackMethod() {
        return Stream.of(
                Arguments.of(0, 0, true),
                Arguments.of(0, 1, false),
                Arguments.of(0, 2, true),
                Arguments.of(0, 3, false)
        );
    }

}
