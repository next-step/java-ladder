package nextstep.refactoring.laddergame.engine.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PlayerNameTest {

    @Test
    @DisplayName("다섯 글자를 넘어가는 이름은 허용하지 않는다.")
    void notAllowExceedFiveLength() {
        String invalidName = "banana";

        assertThatThrownBy(() -> PlayerName.of(invalidName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최소 한 글자가 아니면 예외 처리한다.")
    void throwExceptionIfNameIsTooShort() {
        assertAll(
            () -> assertThatThrownBy(() -> PlayerName.of(null)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> PlayerName.of("")).isInstanceOf(IllegalArgumentException.class)
        );
    }

}
