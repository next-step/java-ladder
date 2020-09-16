package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("direction 판단 테스트")
    public void makeDirectionTest(){
        assertThat(Direction.makeDirection(Direction.RIGHT)).isEqualTo(Direction.LEFT);
        assertThat(Direction.makeDirection(Direction.LEFT)).isIn(Direction.RIGHT, Direction.STOP);
        assertThat(Direction.makeDirection(Direction.STOP)).isIn(Direction.RIGHT, Direction.STOP);
    }
}