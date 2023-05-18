package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @Test
    @DisplayName("5자를 초과할때 예외 throw")
    void exception_case1() {
        String name = "javaisgood";
        assertThatThrownBy(() -> new Player(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 일 때 예외 throw")
    void exception_case2() {
        String name = "";
        assertThatThrownBy(() -> new Player(name)).isInstanceOf(IllegalArgumentException.class);
    }
}