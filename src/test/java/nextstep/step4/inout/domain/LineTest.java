package nextstep.step4.inout.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("Point List를 입력으로, Line 객체를 생성할 수 있다.")
    void testLineConstructor() {
        //given
        List<Point> points = List.of(Point.first(true).next(false), Point.first(true).next(false));

        //when
        Line line = new Line(points);

        //then
        assertThat(line).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("moveIndexProvider")
    @DisplayName("이동 해야 하는 Index를 move 메서드에 입력으로 넣고 실행하면, 이동한 Index를 반환한다.")
    void testMove(final int startIndex, final int expectedIndex) {
        //given
        List<Point> points = List.of(
                Point.first(true),
                Point.first(true).next(false),
                Point.first(false).next(false)
        );
        Line line = new Line(points);

        //when
        int moveIndex = line.move(startIndex);

        //then
        assertThat(moveIndex).isEqualTo(expectedIndex);
    }

    public static Stream<Arguments> moveIndexProvider() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(2, 2)
        );
    }
}
