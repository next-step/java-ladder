package nextstep.ladder;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void create() {
        assertAll(
                () -> assertThat(Point.init(true).move()).isEqualTo(1),
                () -> assertThat(Point.init(false).move()).isEqualTo(0)
        );
    }

    @Test
    void next() {
        assertThatThrownBy(() -> Point.init(true).next(true));
    }

    @Test
    void next2() {
        Point point = Point.init(true);
        assertThat(point.next(false).move()).isEqualTo(0);//(false, true) ,(true, false)
    }

    @Test
    void next3() {
        Point point = Point.init(false);
        assertThat(point.next(false).next(true).move()).isEqualTo(3);
    }

    @Test
    void next4() {
        for (int i = 0; i < 100; i++) {
            assertThat(Point.init(true).next().isCurrent()).isFalse();
        }
    }
}