package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 높이 테스트")
    void getLadderRowSize() {
        Ladder ladder = Ladder.of(3, 5);
        assertThat(ladder.getLadderRowSize()).isEqualTo(5);
    }
}