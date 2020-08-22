package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomDrawStrategyTest {

    private final DrawStrategy drawStrategy = new RandomDrawStrategy();

    @Test
    @DisplayName("draw 두 번 연속 하지 않는지 확인")
    void testDrawNotContinuous() {
        // given
        boolean[] draws = new boolean[10];
        // when
        for (int i = 0; i < draws.length; i++) {
            drawStrategy.draw(i, index -> draws[index] = true);
        }
        // then
        for (int i = 0; i < draws.length - 1; i++) {
            if (draws[i]) {
                assertThat(draws[i]).isNotEqualTo(draws[i + 1]);
            }
        }
    }

    @Test
    @DisplayName("랜덤으로 그리는 지 확인")
    void testRandomDraw() {
        // given
        List<Boolean> draws = new ArrayList<>();
        // when
        for (int i = 0; i < 10; i++) {
            drawStrategy.draw(i, index -> draws.add(true));
        }
        // then
        assertThat(draws).contains(true);
    }
}
