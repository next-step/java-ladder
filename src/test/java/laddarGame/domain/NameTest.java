package laddarGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("이름의 길이는 최대 5글자 이다.")
    @Test
    void position() {
        assertThatThrownBy(
                () -> new PlayerName("SISTER"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}