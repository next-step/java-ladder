package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    @DisplayName("사다리 높이 생성")
    void create() {
        Height height = new Height(5);
        assertThat(height).isEqualTo(new Height(5));
    }

    @Test
    @DisplayName("검증")
    void valid() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}