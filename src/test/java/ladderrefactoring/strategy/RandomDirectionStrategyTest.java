package ladderrefactoring.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomDirectionStrategyTest {

    @Test
    @DisplayName("True 이후 false 반환 확인")
    void create() {
        // give
        DirectionStrategy directionStrategy = new RandomDirectionStrategy(){
            @Override
            protected boolean checkCurrentPoint() {
                return true;
            }
        };

        // when
        boolean checkPoint = directionStrategy.create();

        // then
        assertThat(checkPoint).isFalse();
    }

}