package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class PointTest {

    @Test
    void hasLineBefore() {
        Point point = Point.init(false).next(new TrueReturnStrategy());
        assertThat(point.hasLineBefore()).isEqualTo(true);
    }

    @Test
    void hasNotLineBefore() {
        Point point = Point.init(true).next(new FalseReturnStrategy());
        assertThat(point.hasLineBefore()).isEqualTo(false);
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