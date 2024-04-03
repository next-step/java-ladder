package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.exception.LineConsecutivePointException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("[성공] 라인을 생성한다.")
    void 라인_생성() {
        assertThatNoException().isThrownBy(() -> {
            Line.of(true, false, true, false);
        });
    }

    @ParameterizedTest(name = "[{index}] line.get().get({0}) is {1}")
    @CsvSource(value = {"0:true", "1:false", "2:true"}, delimiter = ':')
    @DisplayName("[성공] 가로 좌표가 있거나 없는 라인을 생성한다.")
    void 라인_생성_가로_라인_유무(int index, boolean bool) {
        Line line = Line.of(true, false, true);
        assertThat(line.get().get(index)).isEqualTo(bool);
    }

    @Test
    @DisplayName("[실패] 라인의 좌표가 연속적으로 true 가 나오는 경우 LineConsecutivePointException 예외가 발생한다.")
    void 라인_생성_예외() {
        assertThatExceptionOfType(LineConsecutivePointException.class)
                .isThrownBy(() -> Line.of(true, true, false))
                .withMessageContaining("하나의 라인에 연속적인 좌표는 가질 수 없습니다.");
    }

    @ParameterizedTest(name = "[{index}] startPosition={0}, expectedPosition={1}, Lines={2}")
    @MethodSource("lineMoveFixture")
    @DisplayName("[성공] 라인의 좌표 정보를 기반으로 위치를 이동시킨다.")
    void 라인_이동(int startPosition, int expectedPosition, List<Boolean> points) {
        assertThat(Line.of(points).move(startPosition)).isEqualTo(expectedPosition);
    }

    static Stream<Arguments> lineMoveFixture() {
        return Stream.of(
                Arguments.of(0, 1, List.of(true, false, true)),
                Arguments.of(0, 0, List.of(false, false, true)),

                Arguments.of(1, 0, List.of(true, false, true)),
                Arguments.of(1, 1, List.of(false, false, false)),
                Arguments.of(1, 2, List.of(false, true, false)),

                Arguments.of(2, 1, List.of(false, true, false)),
                Arguments.of(2, 2, List.of(true, false, false)),

                Arguments.of(3, 2, List.of(false, false, true)),
                Arguments.of(3, 3, List.of(true, false, false))
        );
    }

}
