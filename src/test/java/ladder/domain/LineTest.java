package ladder.domain;

import ladder.exception.PlayersCountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("라인을 생성한다")
    void create() {
        assertThatNoException().isThrownBy(() -> {
            new Line(List.of(firstPoint, next1Point, next2Point, lastPoint));
        });
    }

    @ParameterizedTest(name = "라인생성 오류: 참여자 명수가 0 이하일 경우 오류가 발생한다")
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void create_참여자명_0_음수_오류(int playersCount) {
        assertThatThrownBy(() -> {
            Line actual = new Line(playersCount, () -> true);
        }).isInstanceOf(PlayersCountException.class)
                .hasMessage(NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE);

    }

    @Test
    @DisplayName("포인트들을 조회한다")
    void getPoints() {
        List<Point> points = List.of(firstPoint, next1Point, next2Point, lastPoint);
        Line line = new Line(points);
        List<Point> actual = line.getPoints();

        assertThat(actual).isEqualTo(points);
        assertThatThrownBy(() -> actual.add(next2Point))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}