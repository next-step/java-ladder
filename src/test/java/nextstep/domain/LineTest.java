package nextstep.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void 라인을_생성한다() {
        // given & when & then
        assertDoesNotThrow(() -> {
            new Line(new LineRandom(), 5);
        });
    }

    @ParameterizedTest
    @MethodSource("provider")
    void 사다리타기_방향을_구한다(Line line, int direction) {
        // given & when
        int result = line.getDirection(1);

        // then
        assertThat(result).isEqualTo(direction);
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new Line(List.of(true, false)), Line.LEFT),
                Arguments.of(new Line(List.of(false, false)), Line.DOWN),
                Arguments.of(new Line(List.of(false, true)), Line.RIGHT)
        );
    }
}
