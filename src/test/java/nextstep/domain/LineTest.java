package nextstep.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    public static Line lineFixture(Boolean... points) {
        return new Line(Arrays.stream(points)
                .collect(Collectors.toList()));
    }

    @Test
    void 라인을_생성한다() {
        // given & when & then
        assertDoesNotThrow(() -> {
            new Line(new LineRandom(), 5);
        });
    }

    @ParameterizedTest
    @MethodSource
    void 연속된_라인을_생성하면_예외가_발생한다(List<Boolean> line) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Line(line);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연속적으로 라인이 생성될 수 없습니다.");
    }

    private static Stream<Arguments> 연속된_라인을_생성하면_예외가_발생한다() {
        return Stream.of(
                Arguments.of(List.of(true, true, false)),
                Arguments.of(List.of(false, true, true)),
                Arguments.of(List.of(false, true, true, false))
        );
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
