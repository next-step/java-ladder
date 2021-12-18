package nextstep.ladder.step4.domain.ladder;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import nextstep.ladder.step4.domain.ladder.engine.Line;
import nextstep.ladder.step4.exception.LineMinimumLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DefaultLineTest {

    static Stream<Arguments> generate() {
        List<Point> points = new ArrayList<>();
        Direction direction = Direction.first(FALSE);
        points.add(new Point(0, direction));
        direction = direction.next(TRUE);
        points.add(new Point(1, direction));
        direction = direction.next(FALSE);
        points.add(new Point(2, direction));

        return Stream.of(Arguments.of(new DefaultLine(points)));
    }

    @Test
    @DisplayName("생성 성공")
    void creat() {
        List<Point> points = new ArrayList<>();
        Direction direction = Direction.first(FALSE);
        points.add(new Point(0, direction));
        direction.last();
        points.add(new Point(1, direction));

        assertThat(new DefaultLine(points)).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("최소 길이 예외 처리")
    void lineMinimumLengthException() {
        List<Point> points = new ArrayList<>();
        Direction direction = Direction.first(FALSE);
        points.add(new Point(0, direction));

        assertThatExceptionOfType(LineMinimumLengthException.class)
            .isThrownBy(() -> new DefaultLine(points));
    }

    @ParameterizedTest
    @MethodSource("generate")
    @DisplayName("false false 이동 시")
    void moveStop(Line line) {
        assertThat(line.move(0)).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("generate")
    @DisplayName("true false 이동 시")
    void moveLeft(Line line) {
        assertThat(line.move(2)).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("generate")
    @DisplayName("false true 이동 시")
    void moveRight(Line line) {
        assertThat(line.move(1)).isEqualTo(2);
    }


}
