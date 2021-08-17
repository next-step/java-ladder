package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class HeightTest {
    @Test
    @DisplayName("높이값은 0 이상의 정수이다.")
    public void create() {
        assertThatThrownBy(() -> new Height(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}