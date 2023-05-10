package nextstep.ladder.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("x는 좌측과 우측으로 이동한다.")
    void test01() {
        Position position = new Position(0);
        position.moveRight();
        position.moveRight();
        position.moveRight();
        position.moveLeft();
        assertThat(position.getX()).isEqualTo(2);
    }

    @Test
    @DisplayName("y는 아래로만 이동한다.(값을 반환하지 않아 에러여부만 확인)")
    void test02() {
        Position position = new Position(0);
        Assertions.assertThatNoException()
                .isThrownBy(position::moveDown);
    }

}
