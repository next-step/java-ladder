package nextstep.ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("Position 은 현재 위치를 갖고, 반환한다.")
    void test01() {
        int currentPosition = 3;
        Position position = new Position(currentPosition);
        assertThat(position.getCurrentPosition()).isSameAs(currentPosition);
    }

    @Test
    @DisplayName("Position 은 MovePoint를 받아 새로운 위치를 반환한다.")
    void test02() {
        Position position = new Position(0);
        Position movedPosition = position.move(1);
        assertThat(movedPosition).isNotEqualTo(position);
        assertThat(movedPosition.getCurrentPosition()).isSameAs(1);
    }

}
