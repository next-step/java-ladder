package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @DisplayName("양쪽에 모두 선이 있으면 에러를 반환한다.")
    @Test
    void bothConnectionLineException() {
        assertThatThrownBy(() -> {
            new Direction(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("오른쪽 연결 선이 true이다.")
    @Test
    void lineConnectionRight() {
        Direction direction = Direction.first(true);

        assertThat(direction).isEqualTo(new Direction(false, true));
    }

}