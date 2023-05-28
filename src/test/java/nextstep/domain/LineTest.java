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
    @MethodSource("provider")
    void 사다리타기_방향을_구한다(Line line, Direction direction) {
        // given & when
        Direction result = line.getDirection(1);

        // then
        assertThat(result).isEqualTo(direction);
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new Line(List.of(true, false)), Direction.LEFT),
                Arguments.of(new Line(List.of(false, false)), Direction.DOWN),
                Arguments.of(new Line(List.of(false, true)), Direction.RIGHT)
        );
    }
}
