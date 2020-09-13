package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("direction 판단 테스트")
    public void test(){
        assertThat(Direction.makeDirection(Direction.RIGTH)).isEqualTo(Direction.LEFT);
        assertThat(Direction.makeDirection(Direction.LEFT)).isIn(Direction.RIGTH, Direction.STOP);
        assertThat(Direction.makeDirection(Direction.STOP)).isIn(Direction.RIGTH, Direction.STOP);
    }
}