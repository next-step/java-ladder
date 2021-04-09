package nextstep.ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerNameTest {

    @Test
    @DisplayName("다섯 글자보다 긴 이름은 예외 처리한다.")
    void throwExceptionIfLengthOfNameExceedFive() {
        assertThatThrownBy(() -> new PlayerName("banana")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("특정 이름은 사용할 수 없다.")
    void throwExceptionIfUseForbiddenName() {
        assertThatThrownBy(() -> new PlayerName("all")).isInstanceOf(RuntimeException.class);
    }

}
