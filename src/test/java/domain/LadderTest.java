package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리 생성")
    void createLadder() {
        assertThat(new Ladder(3, 4)).isNotNull();
    }
}