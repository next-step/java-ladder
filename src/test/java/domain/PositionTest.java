package domain;

import exception.NegativePositionException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @Test
    void ofAndEqualsTest() {
        assertThat(Position.of(3)).isEqualTo(Position.of(3));
        assertThatThrownBy(() -> {
            Position.of(-1);
        }).isInstanceOf(NegativePositionException.class);
        assertThat(Position.of(0) == Position.FIRST);
    }
}
