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
        Point point = Point.createFirst();
        point.canRight();

        assertThat(
                        Point.createWithBeforePoint(point).getDirection().isLeft()
        ).isTrue();

        point.canLeft();
        assertThat(
                Point.createWithBeforePoint(point).getDirection().isNotMove()
        ).isTrue();
    }

    @Test
    void createFirstPoint() {
        Point point = Point.createFirst();
        assertThat(point.getIndex()).isEqualTo(0);
    }

    @Test
    void createLastPoint() {
        Point point = Point.createFirst();

        point.canRight();
        Point lastPoint = Point.createLastWithBeforePoint(point);
        assertThat(lastPoint.getDirection().isLeft()).isTrue();

        point.canNotMove();
        lastPoint = Point.createLastWithBeforePoint(point);
        assertThat(lastPoint.getDirection().isNotMove()).isTrue();

    }
}