package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class PointTest {

    @Test
    @DisplayName("생성 테스트")
    void of() {
        assertThatCode(() -> Point.of(true)).doesNotThrowAnyException();
        assertThat(Point.of(true) == Point.of(true)).isTrue();
    }
}
