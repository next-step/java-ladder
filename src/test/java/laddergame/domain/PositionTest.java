package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @DisplayName("사다리 게임의 위치는 0이상이어야 합니다")
    @Test
    void positionLimit(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(-1))
                .withMessage("사다리 게임의 위치는 0이상이어야 합니다");
    }

    @DisplayName("왼쪽으로 위치 이동하면 위치 값이 1 감소한다")
    @Test
    void moveLeft(){
        Position position = new Position(1);

        assertThat(position.moveLeft()).isEqualTo(new Position(0));
    }

    @DisplayName("오른쪽으로 위치 이동하면 위치 값이 1 증가한다")
    @Test
    void moveRight(){
        Position position = new Position(1);

        assertThat(position.moveRight()).isEqualTo(new Position(2));
    }

    @DisplayName("같은 위치인지 확인한다")
    @Test
    void same(){
        Position position = new Position(1);

        assertThat(position.same(1)).isTrue();
    }

}