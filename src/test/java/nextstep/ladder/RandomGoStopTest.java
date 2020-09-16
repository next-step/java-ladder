package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGoStopTest {

    @Test
    @DisplayName("random 생성 테스트")
    public void createRandomTest(){

        assertThat(RandomGoStop.randomGoStop()).isIn(Direction.RIGHT, Direction.STOP);
    }
}