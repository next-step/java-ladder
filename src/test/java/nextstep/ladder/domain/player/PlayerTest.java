package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("다섯 글자보다 긴 이름은 예외 처리한다.")
    void throwExceptionIfLengthOfNameExceedFive() {
        assertThatThrownBy(() -> new Player("banana", 0)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("특정 이름은 사용할 수 없다.")
    void throwExceptionIfUseForbiddenName() {
        assertThatThrownBy(() -> new Player("all", 0)).isInstanceOf(RuntimeException.class);
    }

}
