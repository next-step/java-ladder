package ladder.domain.player;

import static ladder.domain.player.Player.MAXIMUM_NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @Test
    @DisplayName("이름을 바탕으로 새로운 플레이어를 생성한다.")
    void Player_Name() {
        assertThat(new Player("kyle"))
                .isEqualTo(new Player("kyle"));
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("플레이어의 이름이 Null인 경우 예외를 던진다.")
    void Player_NullName_Exception(final String nullName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(nullName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", "\n", "  \n  "})
    @DisplayName("플레이어의 이름이 빈 문자열, 공백, 개행인 경우 예외를 던진다.")
    void Player_BlankName_Exception(final String blankName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(blankName));
    }

    @Test
    @DisplayName("플레이어의 이름이 5자 초과인 경우 예외를 던진다.")
    void Player_NameExceededMinimumLength_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("a".repeat(MAXIMUM_NAME_LENGTH) + 1));
    }
}
