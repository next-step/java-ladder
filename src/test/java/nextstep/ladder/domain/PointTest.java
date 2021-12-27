package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class PointTest {

    @Test
    void hasNotLineBefore() {
        Point point = Point.init(false).next(new TrueReturnStrategy().random());
        assertThat(point.hasLineBefore()).isEqualTo(false);
    }

    @Test
    void hasLineBefore() {
        Point point = Point.init(true).next(new FalseReturnStrategy().random());
        assertThat(point.hasLineBefore()).isEqualTo(true);
    }
    @Test
    void right() {
        Point point = Point.init(false).next(new TrueReturnStrategy().random());
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void down() {
        Point point = Point.init(false).next(new FalseReturnStrategy().random());
        assertThat(point.move()).isEqualTo(Direction.DOWN);
    }

    @Test
    void left() {
        Point point = Point.init(true).next(new FalseReturnStrategy().random());
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void end() {
        Point point = Point.init(false).end();
        assertThat(point.move()).isEqualTo(Direction.DOWN);
    }

    class FalseReturnStrategy implements LineStrategy {
        @Override
        public boolean random() {
            return false;
        }
    }

    class TrueReturnStrategy implements LineStrategy {
        @Override
        public boolean random() {
            return true;
        }
    }
}