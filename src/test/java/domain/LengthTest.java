package domain;

import exception.InvalidLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LengthTest {

    @Test
    @DisplayName("스태틱 팩터리 메서드 테스트")
    void ofTest() {
        assertThat(Length.of(3)).isEqualTo(Length.of(3));
        assertThatThrownBy(() -> {
            Length.of(0);
        }).isInstanceOf(InvalidLengthException.class);
    }
}
