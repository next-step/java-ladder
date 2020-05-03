package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.Fixture.oneUsers;
import static ladder.domain.Fixture.twoUsers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

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
}
