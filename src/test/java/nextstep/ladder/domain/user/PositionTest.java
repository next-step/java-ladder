package nextstep.ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PositionTest {

    @Test
    @DisplayName("Position 을 받아 새로운 위치를 반환한다.")
    void test01() {
        Position position = new Position(0);
        Position movedPosition = position.move(new Position(1));
        assertThat(movedPosition).isNotEqualTo(position);
    }

    @Test
    @DisplayName("현재위치가 처음인지 여부를 판단한다.")
    void test02() {
        Position firstPosition = new Position(0);
        Position notFirstPosition = new Position(1);
        assertAll(
                () -> assertThat(firstPosition.isFirst()).isTrue(),
                () -> assertThat(notFirstPosition.isFirst()).isFalse()
        );
    }

    @Test
    @DisplayName("현재위치를 기준으로 이전위치를 반환한다.")
    void test03() {
        Position firstPosition = new Position(5);
        assertThat(firstPosition.beforePosition()).isEqualTo(new Position(4));
    }

}
