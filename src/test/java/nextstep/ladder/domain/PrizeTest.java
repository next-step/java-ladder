package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeTest {

    @DisplayName("Prize는 0이상이다.")
    @Test
    void validation() {
        assertThatThrownBy(() -> new Prize(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equals() {
        assertThat(new Prize(3))
                .isEqualTo(new Prize(3));
    }
}
