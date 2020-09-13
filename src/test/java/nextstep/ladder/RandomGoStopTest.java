package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomGoStopTest {

    @Test
    @DisplayName("random 생성 테스트")
    public void test(){

        assertThat(RandomGoStop.randomGoStop()).isIn(Direction.RIGTH, Direction.STOP);

        System.out.println(RandomGoStop.randomGoStop());

        Random random = new Random();
        for(int i = 0 ; i < 100 ; i ++){
            System.out.println(random.nextInt(2));
        }
    }
}