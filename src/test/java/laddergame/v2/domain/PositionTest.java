package laddergame.v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("아래로 이동하면 위치 값이 변하지 않는다")
    @Test
    void down(){
        Position position = Position.first(false).next(false);

        assertThat(position.move()).isEqualTo(1);
    }

    @DisplayName("왼쪽로 이동하면 위치 값이 1 감소한다")
    @Test
    void left(){
        Position position = Position.first(true).next(false);

        assertThat(position.move()).isEqualTo(0);
    }

    @DisplayName("오른쪽으로 이동하면 위치 값이 1 증가한다")
    @Test
    void right(){
        Position position = Position.first(false).next(true);

        assertThat(position.move()).isEqualTo(2);
    }
}
