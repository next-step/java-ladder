package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 높이 테스트")
    void getLadderRowSizeTest() {
        Ladder ladder = Ladder.of(3, 5, new FixedGenerator(true));
        assertThat(ladder.getLadderRowSize()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 최소 높이 테스트")
    void ladderMinHeightTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Ladder.of(3, 0, new FixedGenerator(true)))
                .withMessage("사다리 높이는 1이상 이여야 합니다.");
    }

    @Test
    @DisplayName("최소 인원수 테스트")
    void memberMinCountTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Ladder.of(1, 5, new FixedGenerator(true)))
                .withMessage("두 명 이상의 사용자가 참여해야 합니다.");
    }
}