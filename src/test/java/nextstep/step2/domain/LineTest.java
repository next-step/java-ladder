package nextstep.step2.domain;

import nextstep.step2.generator.BooleanGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    @Test
    void 참여인원보다_한개_적은_Line_객체를_생성한다() {
        final var actual = createMockLine(() -> false);

        assertThat(actual.points()).hasSize(3);
    }

    @Test
    void 연속된_라인이_존재하면_예외를_던진다() {
        final var points = List.of(
                new Point(true), new Point(true), new Point(true)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new Line(points)
        );
    }

    @Test
    void 사다리_라인_오른쪽_이동_테스트() {
        final var points = createPoints(true, false, false);
        final var line = new Line(points);
        final var current = 0;

        final var actual = line.move(current);

        assertThat(actual).isEqualTo(current + 1);
    }

    @Test
    void 사다리_라인_왼쪽_이동_테스트() {
        final var points = createPoints(true, false, false);
        final var line = new Line(points);
        final var current = 1;

        final var actual = line.move(current);

        assertThat(actual).isEqualTo(current - 1);
    }

    @Test
    void 사다리_라인_제자리_테스트() {
        final var points = createPoints(false, false, false);
        final var line = new Line(points);
        final var current = 1;

        final var actual = line.move(current);

        assertThat(actual).isEqualTo(current);
    }

    static List<Point> createPoints(boolean point1, boolean point2, boolean point3) {
        return List.of(new Point(point1), new Point(point2), new Point(point3));
    }

    private Line createMockLine(BooleanGenerator generator) {
        return new Line(4, generator);
    }
}
