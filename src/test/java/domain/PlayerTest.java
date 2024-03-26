package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    @DisplayName("매개변수로 넘어오는 문자열이 5자를 초과하면 IllegalArgumentException")
    void from_argument_length_over() {
        assertThatThrownBy(() -> Player.from("abcdeRf")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("매개변수로 넘어오는 문자열이 5자 이하면 정상 생성")
    void from_argument_length_not_over() {
        assertThatNoException().isThrownBy(()->Player.from("abcde"));
    }

    @Test
    @DisplayName("매개변수로 넘어오는 문자열 Player의 불변 필드로 하여 정상 생성")
    void from() {
        assertThat(Player.from("abcde")).isNotNull().isEqualTo(Player.from("abcde"));
    }
}
