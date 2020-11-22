package ladder.domain.model;


import ladder.dto.PointDto;
import ladder.exception.BadPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {
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
    private final Ladder ladder = new Ladder(Arrays.asList(
            line,
            line,
            line
    ));

    @Test
    @DisplayName("Ladder 에 그려진 선 모양대로 position 이 move 해야한다.")
    void move() {
        assertAll(
                () -> assertThat(ladder.move(0))
                        .isEqualTo(0),
                () -> assertThat(ladder.move(1))
                        .isEqualTo(2),
                () -> assertThat(ladder.move(2))
                        .isEqualTo(1),
                () -> assertThat(ladder.move(3))
                        .isEqualTo(3),
                () -> assertThat(ladder.move(4))
                        .isEqualTo(5),
                () -> assertThat(ladder.move(5))
                        .isEqualTo(4),
                () -> assertThat(ladder.move(6))
                        .isEqualTo(6),
                () -> assertThat(ladder.move(7))
                        .isEqualTo(7)
        );
    }

    @Test
    @DisplayName("sizeOfPersons 보다 더 큰 position 을 move 하려 하면, BadPositionException 이 발생한다.")
    void move_BadPosition() {
        assertThatExceptionOfType(BadPositionException.class)
                .isThrownBy(() -> ladder.move(points.size()));
    }

    @Test
    @DisplayName("LinesDto 의 포장을 풀었을 때 값이 일치하는지 확인")
    void exportLinesDto() {
        assertAll(ladder.exportLinesDto()
                .getLines()
                .stream()
                .map(line -> () -> assertThat(
                        line.getPoints()
                                .stream()
                                .map(PointDto::getIsLeft)
                                .collect(toList())
                ).isEqualTo(
                        points.stream()
                                .map(Point::isLeft)
                                .collect(toList())
                ))
        );
    }
}
