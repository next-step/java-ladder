package ladder.domain.model;

import ladder.dto.PointDto;
import ladder.exception.BadPositionException;
import ladder.exception.ConsecutiveDirectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {
    private final List<Point> points = Arrays.asList(
            new Point(0, Direction.DOWN),
            new Point(1, Direction.RIGHT),
            new Point(2, Direction.LEFT),
            new Point(3, Direction.DOWN),
            new Point(4, Direction.RIGHT),
            new Point(5, Direction.LEFT),
            new Point(6, Direction.DOWN),
            new Point(7, Direction.RIGHT));
    private final Line line = new Line(points);

    @Test
    @DisplayName("LEFT 나 RIGHT Point 가 연속하면, ConsecutiveDirectionException 이 발생한다.")
    void constructor() {
        assertAll(
                () -> assertThatExceptionOfType(ConsecutiveDirectionException.class)
                        .isThrownBy(() -> new Line(Arrays.asList(
                                new Point(0, Direction.DOWN),
                                new Point(1, Direction.RIGHT),
                                new Point(2, Direction.RIGHT),
                                new Point(0, Direction.DOWN)))),
                () -> assertThatExceptionOfType(ConsecutiveDirectionException.class)
                        .isThrownBy(() -> new Line(Arrays.asList(
                                new Point(0, Direction.DOWN),
                                new Point(1, Direction.LEFT),
                                new Point(2, Direction.LEFT),
                                new Point(0, Direction.DOWN))))
        );
    }

    @Test
    @DisplayName("라인의 Direction 을 따라 position 이 움직여야 한다.")
    void move() {
        assertAll(
                () -> assertThat(line.move(0))
                        .isEqualTo(0),
                () -> assertThat(line.move(1))
                        .isEqualTo(2),
                () -> assertThat(line.move(2))
                        .isEqualTo(1),
                () -> assertThat(line.move(3))
                        .isEqualTo(3),
                () -> assertThat(line.move(4))
                        .isEqualTo(5),
                () -> assertThat(line.move(5))
                        .isEqualTo(4),
                () -> assertThat(line.move(6))
                        .isEqualTo(6),
                () -> assertThat(line.move(7))
                        .isEqualTo(7)
        );
    }

    @Test
    @DisplayName("Points 갯수보다 더 큰 position 을 move 하려 하면, BadPositionException 이 발생한다.")
    void move_BadPosition() {
        assertThatExceptionOfType(BadPositionException.class)
                .isThrownBy(() -> line.move(points.size()));
    }

    @Test
    @DisplayName("LineDto 의 포장을 풀었을 때 값이 일치하는지 확인")
    void exportLineDto() {
        List<PointDto> points = line.exportLineDto().getPoints();
        assertAll(
                () -> assertThat(points.get(0).getIsLeft())
                        .isFalse(),
                () -> assertThat(points.get(1).getIsLeft())
                        .isFalse(),
                () -> assertThat(points.get(2).getIsLeft())
                        .isTrue(),
                () -> assertThat(points.get(3).getIsLeft())
                        .isFalse(),
                () -> assertThat(points.get(4).getIsLeft())
                        .isFalse(),
                () -> assertThat(points.get(5).getIsLeft())
                        .isTrue(),
                () -> assertThat(points.get(6).getIsLeft())
                        .isFalse(),
                () -> assertThat(points.get(7).getIsLeft())
                        .isFalse()
        );
    }
}
