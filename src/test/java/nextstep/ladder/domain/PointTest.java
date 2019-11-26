package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 20:41
 */
public class PointTest {
    @Test
    void first() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    void move_stay_test() {
        Point point = Point.first(false);
        point = point.next(false);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    void move_left_test() {
        Point point = Point.first(false);
        point = point.next(true);
        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    void move_right_test() {
        Point point = Point.first(true);
        point = point.next(false);
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    public void next() {
        Point second = Point.first(true).next();
        assertThat(second.move()).isEqualTo(0);
    }
}
