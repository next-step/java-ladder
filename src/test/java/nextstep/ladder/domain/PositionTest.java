package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class PositionTest {

    @Test
    void left() {
        Point point = Point.init(true).next(false);
        Position position = new Position(1).move(point);
        assertThat(position.getEndPoint()).isEqualTo(0);
    }

    @Test
    void right() {
        Point point = Point.init(false).next(true);
        Position position = new Position(1).move(point);
        assertThat(position.getEndPoint()).isEqualTo(2);
    }


    @Test
    void pass() {
        Point point = Point.init(false).next(false);
        Position position = new Position(1).move(point);
        assertThat(position.getEndPoint()).isEqualTo(1);
    }
}