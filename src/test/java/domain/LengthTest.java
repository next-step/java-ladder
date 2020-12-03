package domain;

import exception.InvalidLengthException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LengthTest {

    @Test
    void ofTest() {
        assertThat(Length.of(3)).isEqualTo(Length.of(3));
        assertThatThrownBy(() -> {
            Length.of(0);
        }).isInstanceOf(InvalidLengthException.class);
    }
}
