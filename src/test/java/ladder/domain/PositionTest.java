package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("위치값을 생성한다. 초기값을 받을 수 있다.")
    public void create() {
        Assertions.assertThat(Position.from().value()).isEqualTo(0);
        Assertions.assertThat(Position.from(1).value()).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽 위치값을 생성한다. 현재 위치 기준으로 -1 된 값이 리턴 된다")
    public void create_left() {
        Position position = Position.from(1);
        Assertions.assertThat(position.left().value()).isEqualTo(0);
    }

    @Test
    @DisplayName("오른쪽 위치값을 생성한다. 현재 위치 기준으로 +1 된 값이 리턴 된다")
    public void create_right() {
        Position position = Position.from(1);
        Assertions.assertThat(position.right().value()).isEqualTo(2);
    }
}
