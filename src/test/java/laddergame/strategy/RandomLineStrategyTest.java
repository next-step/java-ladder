package laddergame.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineStrategyTest {

    @Test
    @DisplayName("True 이후 false 반환 확인")
    void create() {
        // give
        LineStrategy lineStrategy = new RandomLineStrategy(){
            @Override
            protected boolean checkCurrentPoint() {
                return true;
            }
        };

        // when
        boolean checkPoint = lineStrategy.create();

        // then
        assertThat(checkPoint).isFalse();
    }

}