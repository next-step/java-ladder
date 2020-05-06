package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.Fixture.*;
import static ladder.domain.Fixture.fourLadderGoals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

    @DisplayName("사다리 높이 최소값 테스트")
    @Test
    void testMinimumHeight() {
        int height = 0;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ladder(height, new DirectionGenerator(twoUsers().size())));
    }

    @DisplayName("최소 사용자 수 테스트")
    @Test
    void testMinimumUser() {
        int height = 1;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ladder(height, new DirectionGenerator(oneUsers().size())));
    }

    @DisplayName("사다리의 골과 사용자 숫자가 일치하는지 테스트")
    @Test
    void testGoalsAndUserCounts() {
        int height = 2;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ladder(height, new DirectionGenerator(twoUsers().size())).play(twoUsers(), fourLadderGoals()));
    }
}
