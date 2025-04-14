package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderRowTest {

    @DisplayName("사다리 행을 생성한다.")
    @Test
    void createLadderRow() {
        assertThat(new LadderRow(5)).isNotNull();
    }
}
