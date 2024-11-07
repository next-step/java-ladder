package ladder.domain;

import ladder.exception.PlayersCountException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.Line.NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    private Point firstPoint;
    private Point next1Point;
    private Point next2Point;
    private Point lastPoint;

    @BeforeEach
    void setUp() {
        firstPoint = Point.first(true);
        next1Point = firstPoint.next(false);
        next2Point = next1Point.next(true);
        lastPoint = next2Point.last();
    }

    @Test
    void create() {
        assertThatNoException().isThrownBy(() -> {
            new Line(List.of(firstPoint, next1Point, next2Point, lastPoint));
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void create_참여자명_0_음수_오류(int playersCount) {
        assertThatThrownBy(() -> {
            Line actual = new Line(playersCount, () -> true);
        }).isInstanceOf(PlayersCountException.class)
                .hasMessage(NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE);

    }

    @Test
    void getPoint() {
        List<Point> points = List.of(firstPoint, next1Point, next2Point, lastPoint);
        Line line = new Line(points);
        List<Point> actual = line.getPoints();

        assertThat(actual).isEqualTo(points);
        assertThatThrownBy(() -> actual.add(next2Point))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}