package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeightTest {

    @Test
    @DisplayName("사다리 높이 생성")
    void create() {
        Height height = new Height(5);
        assertThat(height).isEqualTo(new Height(5));
    }


}