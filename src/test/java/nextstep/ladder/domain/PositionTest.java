package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class PositionTest {

    User user = new User(Name.of("temp"));

    @Test
    void left() {
        Point point = Point.init(true).next(false);
        Position position = new Position(1, user).move(point);
        assertThat(position.getIndex()).isEqualTo(0);
    }

    @Test
    void right() {
        Point point = Point.init(false).next(true);
        Position position = new Position(1, user).move(point);
        assertThat(position.getIndex()).isEqualTo(2);
    }


    @Test
    void pass() {
        Point point = Point.init(false).next(false);
        Position position = new Position(1, user).move(point);
        assertThat(position.getIndex()).isEqualTo(1);
    }
}