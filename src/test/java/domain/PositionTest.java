package domain;

import exception.NegativePositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @Test
    @DisplayName("스태틱 팩터리 메서드 테스트")
    void ofTest() {
        assertThat(Position.of(3)).isEqualTo(Position.of(3));
        assertThatThrownBy(() -> {
            Position.of(-1);
        }).isInstanceOf(NegativePositionException.class);

    }
}
