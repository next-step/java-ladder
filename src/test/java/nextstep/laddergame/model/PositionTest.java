package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    @DisplayName("생성자로 위치가 주어졌을 때 제대로 생성되었는지 검증")
    @Test
    void constructTest() {
        int cursur = 10;
        assertThat(new Position(cursur).getCursur()).isEqualTo(cursur);
    }

    @DisplayName("위치가 주어졌을 때 왼쪽으로 더 이동가능한지 체크 검증")
    @ParameterizedTest
    @CsvSource({ "0,false", "1,true" })
    void leftMovableTest(int cursur, boolean expected) {
        assertThat(new Position(cursur).leftMovable()).isEqualTo(expected);
    }

    @DisplayName("위치와 limit가 주어졌을 때 오른쪽으로 더 이동가능한지 체크 검증")
    @ParameterizedTest
    @CsvSource({ "10,10,false", "7,10,true" })
    void leftMovableTest(int cursur, int limit, boolean expected) {
        assertThat(new Position(cursur).rigthMovable(limit)).isEqualTo(expected);
    }

    @DisplayName("왼쪽으로 이동시켰을 때 잘 이동 되었는지 검증")
    @Test
    void moveLeftTest() {
        Position position = new Position(1);
        position.moveLeft();
        assertThat(position.getCursur()).isEqualTo(0);
    }

    @DisplayName("오른쪽으로 이동시켰을 때 잘 이동 되었는지 검증")
    @Test
    void moveRightTest() {
        Position position = new Position(1);
        position.moveRight();
        assertThat(position.getCursur()).isEqualTo(2);
    }
}
