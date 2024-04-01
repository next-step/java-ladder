package ladder;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest
    @NullSource
    @DisplayName("플레이어의 이름이 Null인 경우 예외를 던진다.")
    void Player_NullName(final String nullName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(nullName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", "\n", "  \n  "})
    @DisplayName("플레이어의 이름이 빈 문자열, 공백, 개행인 경우 예외를 던진다.")
    void Player_BlankName(final String blankName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(blankName));
    }
}
