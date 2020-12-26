package nextstep.laddergame.domain;

import nextstep.laddergame.TestStrategy.FalseStrategy;
import nextstep.laddergame.TestStrategy.TrueStrategy;
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

        MovingStrategy trueStrategy = new TrueStrategy();
        Point point = Point.createFirst(trueStrategy);
        assertThat(
                Point.createWithBeforePoint(point, movingStrategy)
                        .canLeft()
        ).isTrue();

        Point point2 = Point.createFirst(trueStrategy);
        Point point3 = Point.createWithBeforePoint(point2, movingStrategy);
        assertThat(
                Point.createWithBeforePoint(point3, movingStrategy)
                        .canNotMove()
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
        MovingStrategy trueStrategy = new TrueStrategy();
        MovingStrategy falseStrategy = new FalseStrategy();
        
        Point point = Point.createFirst(trueStrategy);
        Point lastPoint = Point.createLastWithBeforePoint(point);
        assertThat(lastPoint.canLeft()).isTrue();

        Point point2 = Point.createFirst(falseStrategy);
        lastPoint = Point.createLastWithBeforePoint(point2);
        assertThat(lastPoint.canNotMove()).isTrue();

    }
}