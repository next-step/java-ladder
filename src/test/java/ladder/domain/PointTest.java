package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointTest {

    private Point point;
    private Point nextPoint;

    @BeforeEach
    public void setUp() {
        point = Point.init(() -> true);
        nextPoint = point.createNextPoint(() -> false);
    }

    @DisplayName("첫 번째 유저 포인트는 위치가 0, 방향 좌 false, 우 true")
    @Test
    public void createFirstPoint() {
        assertAll(
                () -> assertThat(point.currentUserPosition()).isEqualTo(0),
                () -> assertThat(point.canMovePrevious()).isFalse(),
                () -> assertThat(point.canMoveNext()).isTrue()
        );
    }

    @DisplayName("다음 유저 포인트의 위치 1, 방향 좌 true, 우 false")
    @Test
    public void createSecondPoint() {
        assertAll(
                () -> assertThat(nextPoint.currentUserPosition()).isEqualTo(1),
                () -> assertThat(nextPoint.canMovePrevious()).isTrue(),
                () -> assertThat(nextPoint.canMoveNext()).isFalse()
        );
    }

    @DisplayName("마지막 유저 포인트 위치 2, 방향 좌 false, 우 false")
    @Test
    public void createLastPoint() {
        Point lastPoint = nextPoint.createLastPoint();

        assertAll(
                () -> assertThat(lastPoint.currentUserPosition()).isEqualTo(2),
                () -> assertThat(lastPoint.canMovePrevious()).isFalse(),
                () -> assertThat(lastPoint.canMoveNext()).isFalse()
        );
    }
}