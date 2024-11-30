package nextstep.laddergame.domain;

import nextstep.laddergame.service.PositionDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @DisplayName("Position 객체를 생성하면 초기 값은 0이다.")
    @Test
    void create() {
        Position given = new Position();

        assertThat(given).isEqualTo(new Position(0));
    }

    @DisplayName("다음 위치 값은 새로운 객체로 생성하여 반환한다.")
    @Test
    void return_next_Position() {
        Position given = new Position(0);

        Position actual = given.next();

        assertThat(given).isEqualTo(new Position(0));
        assertThat(actual)
                .isNotSameAs(given)
                .isEqualTo(new Position(1));
    }

    @DisplayName("PositionDirection 을 전달하면 Position 값을 이동시킨 객체를 반환한다.")
    @Test
    void move() {
        Position given = new Position(1);

        assertThat(given.move(PositionDirection.RIGHT)).isEqualTo(new Position(2));
        assertThat(given.move(PositionDirection.LEFT)).isEqualTo(new Position(0));
    }
}
