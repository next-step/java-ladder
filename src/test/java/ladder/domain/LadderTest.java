package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LadderTest {

    @DisplayName("사디리 생성 생성 테스트")
    @Test
    void testCreateLadder() {
        Ladder ladder = new Ladder(5, 5);

        assertThat(ladder.getLines()).hasSize(5);
    }

    @DisplayName("사다리 높이 최소값 테스트")
    @Test
    void testMinimumHeight() {
        int height = 0;
        int personCount = 2;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ladder(height, personCount));
    }

    @DisplayName("최소 사용자 수 테스트")
    @Test
    void testMinimumUser() {
        int height = 1;
        int personCount = 1;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ladder(height, personCount));
    }
}
