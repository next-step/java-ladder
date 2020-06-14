package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameUserTest {

    @DisplayName("유저이름이 5자를 넘기면 익셉션을 던진다")
    @Test
    void name() {
        assertThatThrownBy(() -> new LadderGameUser(Order.FIRST_ORDER, "abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("유저이름은 5자를 넘길 수 없습니다. 현재글자수: %d", 6));
    }
}