package nextstep.laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    void create() {
        Point point = Point.create(1);
        assertThat(point).isNotNull();
    }

    @Test
    void createPointWithBeforePoint() {
        MovingStrategy movingStrategy = new RandomStrategy();
        Point point = Point.createFirst(movingStrategy);
        point.canRight();

        assertThat(
                Point.createWithBeforePoint(point,movingStrategy)
                        .getDirection()
                        .isLeft()
        ).isTrue();

        point.canLeft();
        assertThat(
                Point.createWithBeforePoint(point,movingStrategy)
                        .getDirection()
                        .isNotMove()
        ).isTrue();
    }

    @Test
    void createFirstPoint() {
        MovingStrategy movingStrategy = new RandomStrategy();
        Point point = Point.createFirst(movingStrategy);
        assertThat(point.getIndex()).isEqualTo(0);
    }

    @Test
    void createLastPoint() {
        MovingStrategy movingStrategy = new RandomStrategy();
        Point point = Point.createFirst(movingStrategy);

        point.canRight();
        Point lastPoint = Point.createLastWithBeforePoint(point);
        assertThat(lastPoint.getDirection().isLeft()).isTrue();

        point.canNotMove();
        lastPoint = Point.createLastWithBeforePoint(point);
        assertThat(lastPoint.getDirection().isNotMove()).isTrue();

    }
}