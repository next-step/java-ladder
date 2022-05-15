package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("player 의 이름은 공백, null값이 될 수 없다.")
    void validationPlayerName(String input) {
        assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("player의 이름은 공백이나 null값이 될 수없습니다.");
    }

    @Test
    @DisplayName("Player의 이름은 5글자를 초과할 수 없다.")
    void validateMaxPlayerNameTest() {
        assertThatThrownBy(() -> new Player("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("player의 이름은 최대 5글자를 초과 할 수 없습니다.");
    }
}
