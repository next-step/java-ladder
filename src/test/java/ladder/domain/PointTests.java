package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTests {
    @DisplayName("생성 테스트")
    @Test
    void create() {
        Point firstPoint = Point.first(true);

        assertThat(firstPoint).isEqualTo(Point.first(true));
    }

    @DisplayName("오른쪽 테스트")
    @Test
    void right() {
        assertThat(Point.first(true).movedDirection()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("왼쪽 테스트")
    @Test
    void left() {
        assertThat(Point.first(true).next(false).movedDirection()).isEqualTo(Direction.LEFT);
        assertThat(Point.first(true).last().movedDirection()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("아래로 지나갈 때 테스트")
    @Test
    void pass() {
        assertThat(Point.first(false).movedDirection()).isEqualTo(Direction.PASS);
    }

    @DisplayName("마지막 값 테스트")
    @Test
    void last() {
        Point point = Point.first(false).last();
        assertThat(point).isEqualTo(Point.first(false).last());
    }

    @DisplayName("그리는 상황 인 지 테스트")
    @Test
    void draw() {
        Point firstPoint = Point.first(true);

        Point secondPoint = Point.first(true).next(false);

        Point thirdPoint = Point.first(true).next(false).last();

        assertThat(firstPoint.isDraw()).isEqualTo(false);

        assertThat(secondPoint.isDraw()).isEqualTo(true);

        assertThat(thirdPoint.isDraw()).isEqualTo(false);
    }

    @DisplayName("인접한 행 다른지 테스트")
    @Test
    void nextRandomFalse() {
        for (int i = 0; i < 100; i++) {
            Point firstPoint = Point.first(true);
            NextStrategy nextStrategy = new RandomNextStrategy();
            Point secondPoint = firstPoint.next(nextStrategy.execute());

            assertThat(firstPoint).isNotEqualTo(secondPoint);
        }
    }

    @DisplayName("인접한 행 안그리는 지 테스트")
    @Test
    void adjacentPointRandomFalse() {
        for (int i = 0; i < 100; i++) {
            Point firstPoint = Point.first(false);
            NextStrategy nextStrategy = new RandomNextStrategy();
            Point secondPoint = firstPoint.next(nextStrategy.execute());

            assertThat(secondPoint.isDraw()).isFalse();
        }
    }
}
