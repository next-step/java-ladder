package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.Fixture.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LadderTest {
    private static final int HEIGHT = 2;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(HEIGHT, new DirectionGenerator(twoUsers().size()));
    }

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
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ladder(HEIGHT, new DirectionGenerator(oneUsers().size())));
    }

    @DisplayName("사다리의 골과 사용자 숫자가 일치하는지 테스트")
    @Test
    void testGoalsAndUserCounts() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ladder.play(twoUsers(), fourLadderGoals()));
    }
}
