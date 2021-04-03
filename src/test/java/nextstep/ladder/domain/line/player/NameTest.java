package nextstep.ladder.domain.line.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("다섯 글자보다 긴 이름은 예외 처리한다.")
    void throwExceptionIfLengthOfNameExceedFive() {
        assertThatThrownBy(() -> new Name("banana")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("특정 이름은 사용할 수 없다.")
    void throwExceptionIfUseForbiddenName() {
        assertThatThrownBy(() -> new Name("all")).isInstanceOf(RuntimeException.class);
    }

}
